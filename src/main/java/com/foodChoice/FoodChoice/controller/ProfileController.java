package com.foodChoice.FoodChoice.controller;

import com.foodChoice.FoodChoice.entities.Profile;
import com.foodChoice.FoodChoice.entities.User;
import com.foodChoice.FoodChoice.repository.UserRepository;
import com.foodChoice.FoodChoice.service.ProfileService;
import com.foodChoice.FoodChoice.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class ProfileController {
    @Autowired
    private ProfileService profileService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/profile")
    public String getProfile(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User user = userRepository.findByEmail(currentPrincipalName);
        model.addAttribute("user", user);

        return "profile";
    }
    @GetMapping("/profile/{id}")
    String profilePage(Model model, @PathVariable Long id) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "profile";
    }

    @GetMapping("/addProfile")
    public String createProfile(Model model, @PathVariable Long id) {

        User userId = userService.findById(id);
        Profile profile = new Profile();
        profile.setUser(userId);
        model.addAttribute("user", userId);
        model.addAttribute("profile", profile);
        return "profile";
    }

    @PostMapping("/saveProfile")
    public String saveProfile(@ModelAttribute Profile profile, @RequestParam Long user) {
        User userId = userService.findById(user);
        profileService.addProfile(profile);
        return "redirect:/user/profile/" + userId.getId();
    }
    @GetMapping("/editProfile")
    public String editProfile(@RequestParam Long id,Model model){
        User user = userService.findById(id);
        model.addAttribute("user",user);
        return "editProfile";
    }

    @GetMapping("/deleteProfile/{id}")
    public String deleteMeal(@PathVariable Long id){
        Profile profile = profileService.findById(id);
        profileService.deleteById(id); //Raderar profil
        return "redirect:/user/editProfile?id=" + profile.getUser().getId();//Skickar tillbaka till /mealList
    }

}
