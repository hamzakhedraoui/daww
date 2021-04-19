package com.example.demo.controller;

import com.example.demo.models.Command;
import com.example.demo.models.Plate;
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

import java.util.List;

@Controller
public class CommandController {

    private CommandService commandService;
    @Autowired
    public CommandController(CommandService commandService){}
    @RequestMapping("/c")
    public String viewHomePage(Model model) {
        List<Command> listCommand = commandService.listAll();
        model.addAttribute("listCommand", listCommand);
        return "indexc";
    }
    @RequestMapping("/c/new")
    public String showNewProductPage(Model model) {
        Command command = new Command();
        model.addAttribute("command", command);

        return "new_command";
    }
    @RequestMapping(value = "/c/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("command") Command command) {
        commandService.save(command);
        return "redirect:/";
    }
    @RequestMapping("/c/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_command");
        Command command = commandService.get(id);
        mav.addObject("command", command);
        return mav;
    }
    @RequestMapping("/c/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id) {
        commandService.delete(id);
        return "redirect:/";
    }
}
