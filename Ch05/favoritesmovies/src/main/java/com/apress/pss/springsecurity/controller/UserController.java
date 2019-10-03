package com.apress.pss.springsecurity.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @GetMapping ("/")
    public String homePage() {
        return "index";
    }

    @GetMapping ("/index")
    public String index() {
        return "index";
    }

    @GetMapping ("/movies")
    public String movies() {
        return "movies";
    }

    @GetMapping("/showmovie")
    @ResponseBody
    public String showMovie() {
        return "My favorite movie: il postino";
    }

    //@GetMapping("/login") use when custom login is used
    //public String loginPage() {
    //    return "login";
    //}

    @GetMapping ("/logout")
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "index";
    }
}
