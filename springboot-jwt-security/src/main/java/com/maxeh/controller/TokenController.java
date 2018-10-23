package com.maxeh.controller;

import com.maxeh.model.JwtUser;
import com.maxeh.security.JwtGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/token")
public class TokenController {

    @Autowired
    private JwtGenerator jwtGenerator;

    @PostMapping
    public String generate(@RequestBody JwtUser jwtUser) {
        return jwtGenerator.generate(jwtUser);
    }
}
