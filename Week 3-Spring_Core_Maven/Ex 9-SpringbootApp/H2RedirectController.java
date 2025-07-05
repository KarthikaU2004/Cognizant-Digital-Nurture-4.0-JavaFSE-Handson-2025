package com.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class H2RedirectController {

    @GetMapping("/")
    public String redirectToH2Console() {
        return "redirect:/h2-console";
    }
}


