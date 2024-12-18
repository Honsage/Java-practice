package com.example.primitivespringauthentication.controller;

import com.example.primitivespringauthentication.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {
    private User registeredUser;
    private boolean isAuthenticated = false;
    private String voteResult;

    @GetMapping("/")
    public String showRegisterPage() {
        return "register";
    }

    @GetMapping("/register")
    public String showRegisterPageAgain() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username,
                           @RequestParam String password, Model model) {
        if (username.isEmpty() || password.isEmpty()) {
            model.addAttribute("error", "Имя пользователя и пароль не должны быть пустыми!");
            return "register";
        }
        registeredUser = new User(username, password);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password, Model model) {
        if (registeredUser == null ||
                !registeredUser.getUsername().equals(username) ||
                !registeredUser.getPassword().equals(password)) {
            model.addAttribute("error", "Неверное имя пользователя или пароль!");
            return "login";
        }
        isAuthenticated = true;

        return "redirect:/home";
    }

    @GetMapping("/home")
    public String showHomePage(Model model) {
        if (!isAuthenticated) {
            return "redirect:/login";
        }
        model.addAttribute("username", registeredUser.getUsername());
        model.addAttribute("voteResult", this.voteResult);

        return "home";
    }

    @PostMapping("/home")
    public String formSubmit(@RequestParam String option, Model model) {
        System.out.println("POST REQUEST");
        this.voteResult = option;
        return "redirect:/home";
    }
}
