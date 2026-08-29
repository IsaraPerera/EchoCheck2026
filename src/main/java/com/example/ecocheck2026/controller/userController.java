package com.example.ecocheck2026.controller;

import com.example.ecocheck2026.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("v1/api/users")
@RestController
public class userController {
    @PostMapping
    public ResponseEntity<Void>createUser(@RequestBody UserDTO userDTO){

    }
}
