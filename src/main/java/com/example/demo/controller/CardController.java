package com.example.demo.controller;

import com.example.demo.models.Card;
import com.example.demo.models.Command;
import com.example.demo.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CardController {
    private CardService cardService;
    @Autowired
    public CardController(CardService cardService){this.cardService = cardService;}
    @RequestMapping("/ca")
    public String viewHomePage(Model model) {
        List<Card> listCard = cardService.listAll();
        model.addAttribute("listCard", listCard);
        return "indexca";
    }
    @RequestMapping("/ca/new")
    public String showNewProductPage(Model model) {
        Command command = new Command();
        model.addAttribute("command", command);

        return "new_card";
    }
    @RequestMapping(value = "/ca/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("card") Card card) {
        cardService.save(card);
        return "redirect:/";
    }
    @RequestMapping("/ca/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_card");
        Card card = cardService.get(id);
        mav.addObject("card", card);
        return mav;
    }
    @RequestMapping("/ca/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id) {
        cardService.delete(id);
        return "redirect:/";
    }
    @RequestMapping("/c/add/{id}")
    public String deleteProdduct(@PathVariable(name = "id") int id) {
        Card card = new Card(0,AppController.id,id,0);
        cardService.save(card);
        return "redirect:/recherch";
    }
}
