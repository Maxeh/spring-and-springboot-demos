package com.maxeh.controller;

import com.maxeh.repository.UserRepository;
import com.maxeh.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

// Note: Normally you would call the service layer which then calls the DAO layer.
// The controller should not connect to the db directly.

@Controller
@RequestMapping("/hibernate")
public class OrmController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/add")
    public String addNewUser (@RequestParam String name, @RequestParam String email) {
        User n = new User(name, email);
        userRepository.save(n);
        return "data-saved";
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll(); // returns a JSON or XML with the users
    }

    @GetMapping("/showById")
    public @ResponseBody Optional<User> showUser(@RequestParam(value = "id", defaultValue = "1") Integer id) {
        return userRepository.findById(id); // returns a JSON or XML with the users
    }

    @GetMapping("/showByDomain")
    public @ResponseBody Iterable<User> showUsers(@RequestParam(value = "domain", defaultValue = "") String domain) {
        return userRepository.findByEmailDomain(domain); // returns a JSON or XML with the users
    }

    @GetMapping("/updateById")
    public @ResponseBody String updateUser(@RequestParam(value = "id", defaultValue = "1") Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setEmail("xxx@xxx.de");
            userRepository.save(user);
            return "Updated successfully.";
        }
        else return "Updating failed.";
    }

    @GetMapping("/deleteById")
    public @ResponseBody String deleteUser(@RequestParam(value = "id", defaultValue = "1") Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            userRepository.delete(user);
            return "Delete successful.";
        }
        else return "Delete failed.";
    }
}