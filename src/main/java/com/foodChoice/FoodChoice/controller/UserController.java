package com.foodChoice.FoodChoice.controller;

import com.foodChoice.FoodChoice.entities.User;
import com.foodChoice.FoodChoice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private BCryptPasswordEncoder bp;
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String homePage(){
        return"home";
    }
    @GetMapping("/register")
    public String loginPage(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult);
            return "register";
        }
        model.addAttribute("user", user);
        user.setPassword(bp.encode(user.getPassword()));
        user.setRole("ROLE_USER");
        userService.addUser(user);
        return "redirect:/user/profile/";
    }

    @GetMapping("/login")
    public String Login(Model model){
        User user=new User();


        model.addAttribute("user",user);
        return "login";
    }

}
