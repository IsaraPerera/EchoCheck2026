package com.example.ecocheck2026.controller;

import com.example.ecocheck2026.dto.UserDTO;
import com.example.ecocheck2026.service.UserService;
import com.example.ecocheck2026.service.impl.UserServiceIMPL;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/v1/users")
@RestController
@RequiredArgsConstructor
public class userController {
    private final UserService userService;
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void>createUser(@RequestBody UserDTO userDTO){
        userService.saveUser(userDTO);
        return  new ResponseEntity<>(HttpStatus.CREATED);

    }
    @GetMapping(value ={"/{userId}"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO>getSelectedUser(@PathVariable String userId){
        System.out.println("selected user:" + userId);
        return  new ResponseEntity<>(userService.getSelectedUser(userId),HttpStatus.OK);

    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDTO>>getAllUsers(){
        return  new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
    }
    @PatchMapping(value ={"/{userId}"},consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void>updateUser(@PathVariable String userId,@RequestBody UserDTO userDTO){
        userService.updateUser(userId, userDTO);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
    @DeleteMapping(value = {"/{userId}"})
    public ResponseEntity<Void>deleteUser(@PathVariable String userId){
        userService.deleteUser(userId);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
