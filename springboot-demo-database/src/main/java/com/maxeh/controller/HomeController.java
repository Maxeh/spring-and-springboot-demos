package com.maxeh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String home(Model model) {
        model.addAttribute("name", "Maxeh");
        return "home";
    }

    @GetMapping("info")
    // @ResponseBody means the returned String is the response, not a view name
    public @ResponseBody String test() {
        return "This is a simple test app.";
    }
}
