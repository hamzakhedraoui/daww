package com.example.demo.controller;

import com.example.demo.models.Card;
import com.example.demo.models.Command;
import com.example.demo.models.Plate;
import com.example.demo.services.CardService;
import com.example.demo.services.CommandService;
import com.example.demo.services.PlateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PlateController {

    private PlateService plateService;
    private CardService cardService;
    private CommandService commandService;
    @Autowired
    public PlateController(PlateService plateService,CardService cardService,CommandService commandService){
        this.plateService = plateService;
        this.cardService=cardService;
        this.commandService = commandService;
    }
    @RequestMapping("/p")
    public String viewHomePage(Model model) {
        List<Plate> listPlate = plateService.listAll();
        model.addAttribute("listPlate", listPlate);
        return "indexp";
    }
    @RequestMapping("/card")
    public String viewHomePdage(Model model) {
        List<Card> listCard = cardService.listAll();
        List<Plate> listPlate = new ArrayList<>();
        double totalPrice = 0;
        for(Card card:listCard){
            Plate plate = plateService.get(card.getPlateId());
            totalPrice = totalPrice + plate.getPrix();
            listPlate.add(plate);
        }
        model.addAttribute("totalPrice",totalPrice);
        model.addAttribute("listPlate", listPlate);
        return "card";
    }
    @RequestMapping("/recherch")
    public String viewHomesPage(Model model) {
        List<Plate> listPlate = plateService.listAll();
        model.addAttribute("listPlate", listPlate);
        return "recherchPlate";
    }
    @RequestMapping("/p/new")
    public String showNewProductPage(Model model) {
        Plate plate = new Plate();
        model.addAttribute("plate", plate);

        return "new_plate";
    }
    @RequestMapping("/ca/order")
    public String showNewProsductPage(Model model) {
        List<Card> listCard = cardService.listAll();
        List<Plate> listPlate = new ArrayList<>();
        double totalPrice = 0;
        for(Card card:listCard){
            if(card.getClientId()==AppController.id) {
                    Command command = new Command(0,AppController.id,0,card.getPlateId(),0,"R_WAIT",0,0);
                    commandService.save(command);
                    cardService.delete(card.getId());
            }
        }
        return "redirect:/recherch";
    }
    @RequestMapping(value = "/p/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("plate") Plate plate) {
        plateService.save(plate);
        return "redirect:/p";
    }
    @RequestMapping("/p/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_plate");
        Plate plate = plateService.get(id);
        mav.addObject("plate", plate);
        return mav;
    }
    @RequestMapping("/p/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id) {
        plateService.delete(id);
        return "redirect:/p";
    }
}
