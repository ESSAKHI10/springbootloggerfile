package com.example.logtestapi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.logtestapi.Entity.User;

import com.example.logtestapi.Service.IUserService;

@RestController
@RequestMapping("api/v1/user")
public class userController {

    @Autowired
    private IUserService userService;

    @GetMapping("/sayHello")
    public ResponseEntity<String> sayHello() {
        System.out.println("hello ");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<String>("Hello", HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<User> newUser(@RequestBody User user) {
        User newUser = userService
                .createUser(User.builder()
                        .firstName(user.getFirstName())
                        .lastName(user.getLastName())
                        .email(user.getEmail())
                        .build());
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getUsers() {
        try {
            return new ResponseEntity<>(userService.findAllUser(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
