package com.example.oauth2login.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";  // home.html will have the "Sign in with GitHub" link/button
    }

    @GetMapping("/profile")
    public String profile(Model model, @AuthenticationPrincipal OAuth2User user) {
        System.out.println("GitHub User Attributes: " + user.getAttributes()); // Debugging

        model.addAttribute("name", user.getAttribute("name"));
        model.addAttribute("login", user.getAttribute("login"));
        model.addAttribute("avatar_url", user.getAttribute("avatar_url"));
        model.addAttribute("location", user.getAttribute("location"));
        return "profile";  // profile.html
    }
}
