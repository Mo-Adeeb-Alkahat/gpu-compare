package com.aha.GPU_Compare.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin")
@Controller
public class AdminController {



    @GetMapping("/login")
    public String getLogin() {

        return "login";
    }
}
