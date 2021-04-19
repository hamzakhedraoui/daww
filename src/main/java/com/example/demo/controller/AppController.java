package com.example.demo.controller;

import com.example.demo.models.Account;
import com.example.demo.models.Login;
import com.example.demo.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AppController {

    private AccountService accountService;
    @Autowired
    public AppController(AccountService accountService){this.accountService = accountService;}
    public static boolean loged = false;
    public static long id = 0;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
            return "redirect:/login";
    }
    @RequestMapping("/login")
    public String logout(Model model) {
        Login login = new Login();
        model.addAttribute("login", login);
        return "login";
    }
    @RequestMapping("/log")
    public String log(@ModelAttribute("Login") Login login) {
        List<Account> accounts = accountService.listAll();
        try {

            for(Account a : accounts){
                if(a.getEmail().equals(login.getEmail())){
                    if(a.getPassword().equals(login.getPassword())){
                        AppController.id = a.getId();
                        if(a.getType().equals("L")){
                            return "redirect:/";
                        }else if(a.getType().equals("R")){
                            return "redirect:/p";
                        }else if(a.getType().equals("C")){
                            return "redirect:/recherch";
                        }
                        loged = true;
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return "redirect:/login";
    }
    @RequestMapping("/logout")
    public String login(Model model) {
        loged = false;
        return "redirect:/login";
    }
    @RequestMapping("/a")
    public String viewHomePagea(Model model) {
        List<Account> listAccount = null;
        try {
            listAccount = accountService.listAll();
        }catch (Exception e){}
        if(listAccount==null)
            listAccount = new ArrayList<Account>();
        model.addAttribute("listAccount", listAccount);
        return "index";
    }
    @RequestMapping("/a/new")
    public String showNewProductPage(Model model) {
        Account account = new Account();
        model.addAttribute("account", account);
        return "new_account";
    }
    @RequestMapping("/a/c/new")
    public String showNewProductPagec(Model model) {
        Account account = new Account();
        model.addAttribute("account", account);
        return "signup";
    }
    @RequestMapping(value = "/a/c/save", method = RequestMethod.POST)
    public String savseProduct(@ModelAttribute("account") Account account) {
        account.setType("C");
        System.out.println(account);
        accountService.save(account);
        return "redirect:/a";
    }
    @RequestMapping(value = "/a/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("account") Account account) {
        accountService.save(account);
        return "redirect:/a";
    }
    @RequestMapping("/a/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_account");
        Account account = accountService.get(id);
        mav.addObject("account", account);
        return mav;
    }
    @RequestMapping("/a/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id) {
        accountService.delete(id);
        return "redirect:/";
    }

}
