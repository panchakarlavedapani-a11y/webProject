package com.worknestapp.controller;

import com.worknestapp.model.User;
import com.worknestapp.service.UserService;
import com.worknestapp.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class AuthController {
    private UserService userService = new UserServiceImpl();

    @GetMapping({"/","/index"})
    public String index(){ return "index"; }

    @GetMapping("/register")
    public String registerForm(){ return "register"; }

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password, @RequestParam(defaultValue="USER") String role){
        User u = new User(username, password, role);
        userService.register(u);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginForm(){ return "login"; }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session, Model model){
        User u = userService.login(username, password);
        if(u==null){
            model.addAttribute("error", "Invalid credentials");
            return "login";
        }
        session.setAttribute("currentUser", u);
        if("ADMIN".equals(u.getRole())) return "redirect:/admin/dashboard";
        return "redirect:/user/dashboard";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login";
    }
}
