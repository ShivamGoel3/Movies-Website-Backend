package com.example.demo.Service;

import com.example.demo.Entity.User;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface Userservice {
  //  public List<User> getalluser();

   public List<User> alluser();

   public ResponseEntity<String> login(User user);

    public ResponseEntity<String> signup(User user);
    public FilterRegistrationBean coresFilter();

    public ResponseEntity<String> forget(User user);
}
