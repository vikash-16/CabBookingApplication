package com.example.CabBookingApplication.controller;

import com.example.CabBookingApplication.dto.UserRequestDto;
import com.example.CabBookingApplication.service.UserService;
import jakarta.annotation.Resources;
import org.springframework.boot.autoconfigure.security.oauth2.server.servlet.OAuth2AuthorizationServerJwtAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/addUser")
    public ResponseEntity<String> addUsers(@RequestBody UserRequestDto userRequestDto) {
        return new ResponseEntity<>(userService.addUsers(userRequestDto), HttpStatus.OK);
    }
    @GetMapping("/getUser")
    public ResponseEntity<Object>getUsers() {
        return new ResponseEntity<>(userService.getUsers(),HttpStatus.OK);
    }
}
