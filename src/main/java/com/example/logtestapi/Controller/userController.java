package com.example.logtestapi.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.logtestapi.Entity.User;
import com.example.logtestapi.ReturnStatement.ResponseData;
import com.example.logtestapi.ReturnStatement.ReturnStatement;
import com.example.logtestapi.Service.IUserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperties;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import io.swagger.v3.oas.annotations.tags.Tag;

import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("api/v1/user")
@Tag(name = "user api ", description = "**STATUS CODE: \n\n "
        + " ###### -0000:DONE  \n\n"
        + " ###### -0001:NOT DONE \n\n "
        + " ###### -0002:NOT DONE \n\n"
        + " ###### -0003:NOT DONE \n\n "
        + " ######  STATUS CODE : 0000:DONE ,0001:NOT DONE,0002:NOT DONE ,0003:NOT DONE\n\n ")
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

    @Operation(summary = "Finds a person", description = "STATUS CODE: \n\n " + "-0000:DONE  \n\n"
            + "-0001:NOT DONE ", tags = { "People" }, responses = {
                    @ApiResponse(description = "Success", responseCode = "200", content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @Schema(example = "{statusCode:string,statuslabel:string,responseData:{isAuth:0,userdata:list user }}", type = "object", implementation = ReturnStatement.class))),

    })

    public ResponseEntity<Map<String, Object>> getUsers() {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("status code", "000");
        data.put("status label", "list user");
        data.put("response data", userService.findAllUser());
        try {
            return new ResponseEntity<Map<String, Object>>(data, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
