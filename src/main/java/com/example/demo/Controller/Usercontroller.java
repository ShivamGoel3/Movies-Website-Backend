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

    @GetMapping("/")
    public String fetch()
    {

        return "<h1>Hi! This is Movies Tv Series Website Backend.</h1><br>"+
                "<h1>To use Login page, Send Email and Password.</h1><br>"+
                "<h1>To use Signup page, Send Email, Name, Age, Mobilenumber, Password.</h1><br>"+
                "<h1>To use Forget page, Send Email and new Password.</h1>";
    }
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
