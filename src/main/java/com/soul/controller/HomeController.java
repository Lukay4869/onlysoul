package com.soul.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin")
@Controller
public class HomeController {
    @RequestMapping("/welcome")
    public String welcome(){
        return "welcome";
    }
}
