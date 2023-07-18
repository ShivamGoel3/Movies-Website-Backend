package com.example.demo.Controller;


import com.example.demo.Entity.User;
import com.example.demo.Service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin("*")
public class Usercontroller {

    @Autowired
    Userservice userservice;
    @GetMapping("/alluser")
    public List<User> alluser()
    {
        return userservice.alluser();
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user)
    {
     return userservice.login(user);
    }
    @PostMapping("/forget")
    public ResponseEntity<String> forget(@RequestBody User user)
    {
        return userservice.forget(user);
    }
    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody User user)
    {

        return userservice.signup(user);
    }
}
