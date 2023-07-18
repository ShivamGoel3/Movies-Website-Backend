package com.example.demo.Service;

import com.example.demo.Entity.User;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

import com.example.demo.Repository.Userrepository;
//import org.apache.catalina.filters.CorsFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Service
public class UserserviceImpl implements Userservice {
    @Autowired
    private Userrepository userrepository;

    @Override
    public List<User> alluser() {
       // HashSet<User> userList = new HashSet<User>();

            return userrepository.findAll();
    }
    @Override
    public ResponseEntity<String> login(User user) {
        // HashSet<User> userList = new HashSet<User>();
User u=userrepository.findById(user.getEmail()).orElse(null);

if(u==null)
    return new ResponseEntity<>("User Not Registered", HttpStatus.OK);
else{

    if(u.getPassword().equals( user.getPassword()))
        return new ResponseEntity<>("Successful", HttpStatus.OK);
    else
        return new ResponseEntity<>("Invalid credentials", HttpStatus.OK);
}

       // return userrepository.findAll();
    }
    @Override
    public ResponseEntity<String> signup(User user) {
        // HashSet<User> userList = new HashSet<User>();
        User u=userrepository.findById(user.getEmail()).orElse(null);
     // System.out.println(user.getAge());
        if(u!=null)
            return new ResponseEntity<>("User already exists", HttpStatus.OK);
        else {
            userrepository.save(user);
            return new ResponseEntity<>("Successful", HttpStatus.OK);
        }

    }

    @Override
    public ResponseEntity<String> forget(User user) {
        // HashSet<User> userList = new HashSet<User>();
        User u=userrepository.findById(user.getEmail()).orElse(null);
        // System.out.println(user.getAge());
        if(u==null)
            return new ResponseEntity<>("Account not exist", HttpStatus.OK);
        else {
            u.setPassword(user.getPassword());
            userrepository.save(u);
            return new ResponseEntity<>("Password Changed", HttpStatus.OK);
        }

    }

    @Bean
  public  FilterRegistrationBean coresFilter(){
        UrlBasedCorsConfigurationSource source=new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration=new CorsConfiguration();
      corsConfiguration.setAllowCredentials(true);
      corsConfiguration.addAllowedOriginPattern("*");
corsConfiguration.addAllowedHeader("Authorization");
        corsConfiguration.addAllowedHeader("Content-Type");
        corsConfiguration.addAllowedHeader("Accept");
        corsConfiguration.addAllowedMethod("POST");
        corsConfiguration.addAllowedMethod("GET");
        corsConfiguration.addAllowedMethod("DELETE");
        corsConfiguration.addAllowedMethod("PUT");
        corsConfiguration.addAllowedMethod("OPTIONS");
corsConfiguration.setMaxAge(3600L);
        source.registerCorsConfiguration("/**",corsConfiguration);
        FilterRegistrationBean bean=new FilterRegistrationBean(new CorsFilter(source));
return bean;

    }
    }