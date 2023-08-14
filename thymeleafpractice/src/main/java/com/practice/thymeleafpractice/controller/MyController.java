package com.practice.thymeleafpractice.controller;

import org.springframework.ui.Model;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
public class MyController {
    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about(Model model)
    {
        System.out.println("Inside about handler...");

        model.addAttribute("name", "Ritika Jaiswal");
        model.addAttribute("currentDate", new Date().toLocaleString());
        return "about";
        //about html
    }
}
