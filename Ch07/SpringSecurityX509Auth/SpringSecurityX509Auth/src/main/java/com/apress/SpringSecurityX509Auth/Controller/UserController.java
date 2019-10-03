package com.apress.SpringSecurityX509Auth.Controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.apress.SpringSecurityX509Auth.Domain.User;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {

    @Secured("ROLE_USER")

    @RequestMapping(value = {"/","/admin"}, method = RequestMethod.GET)
    public ModelAndView admin() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin");


        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        modelAndView.addObject("currentUser", auth.getName());
        User user = new User();
        modelAndView.addObject("currentUser2", auth.getPrincipal());
        return modelAndView;
    }


    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**");
    }

}
