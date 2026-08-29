package com.example.ecocheck2026.controller;

import com.example.ecocheck2026.dto.UserDTO;
import com.example.ecocheck2026.dto.enums.Role;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("api/v1/users")
@RestController
public class userController {
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void>createUser(@RequestBody UserDTO userDTO){
        System.out.println("create user:" + userDTO.toString());
        return  new ResponseEntity<>(HttpStatus.CREATED);

    }
    @GetMapping(name =("userId"),produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO>getSelectedUser(@PathVariable String userId){
        System.out.println("selected user:" + userId);
        return  new ResponseEntity<>(new UserDTO("U0001","Isara","Perera","isaraperera2005@gmail.com","Issa",Role.ADMIN),HttpStatus.OK);

    }
}
