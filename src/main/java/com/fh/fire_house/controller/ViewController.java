package com.fh.fire_house.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class ViewController {

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

}
