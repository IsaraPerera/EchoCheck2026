package com.example.ecocheck2026.controller;

import com.example.ecocheck2026.dto.UserDTO;
import com.example.ecocheck2026.dto.enums.Role;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/v1/users")
@RestController
public class userController {
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void>createUser(@RequestBody UserDTO userDTO){
        System.out.println("create user:" + userDTO.toString());
        return  new ResponseEntity<>(HttpStatus.CREATED);

    }
    @GetMapping(value ={"/{userId}"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO>getSelectedUser(@PathVariable String userId){
        System.out.println("selected user:" + userId);
        return  new ResponseEntity<>(new UserDTO("U0001","Isara","Perera","isaraperera2005@gmail.com","Issa",Role.ADMIN),HttpStatus.OK);

    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDTO>>getUsers(){
        List<UserDTO> userList= List.of(
                new UserDTO(
                        "U0001",
                        "Isara",
                        "Perera",
                        "isaraperera2005@gmail.com",
                        "Issa",
                        Role.ADMIN
                ),
                new UserDTO(
                        "U0002",
                        "Tusheni",
                        "Perera",
                        "tushi@gmail.com",
                        "tush",
                        Role.ADMIN
                ));
                return  new ResponseEntity<>(userList,HttpStatus.OK);


    }
    @PatchMapping(value ={"/{userId}"},consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void>updateUser(@PathVariable String userId,@RequestBody UserDTO userDTO){
        System.out.println("To be updated the userid : " +userId+ "as:" + userDTO.toString());
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
    @DeleteMapping(value = {"/{userId}"})
    public ResponseEntity<Void>deleteUser(@PathVariable String userId){
        System.out.println("Deleted user id : " +userId);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
