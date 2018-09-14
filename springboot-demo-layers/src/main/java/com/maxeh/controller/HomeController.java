package com.maxeh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String home() {
        return "Hello world<br>Go to <a href=\"/students\">/students</a>";
    }
}