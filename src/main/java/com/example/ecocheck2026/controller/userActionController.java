package com.example.ecocheck2026.controller;

import com.example.ecocheck2026.dto.UserActionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/useraction")
public class userActionController {
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createUserAction(@RequestBody UserActionDTO userActionDTO){
        System.out.println("create user action :" + userActionDTO.toString());
        return  new ResponseEntity<>(HttpStatus.CREATED);

    }
    @GetMapping(value ={"/{userActionId}"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserActionDTO>getSelectedUserAction(@PathVariable String userActionId){
        System.out.println("selected user action :" + userActionId);
        return  new ResponseEntity<>(new UserActionDTO("UA-901","3","37.5 kgCO2e","2026-08-15","U0001", "ACT-101"),HttpStatus.OK);

    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserActionDTO>>getUserActions(){
        List<UserActionDTO> userList= List.of(
                new UserActionDTO(
                        "UA-901",
                        "3",
                        "37.5 kgCO2e",
                        "2026-08-15",
                        "U0001",
                        "ACT-101"
                ),
                new UserActionDTO(
                        "UA-902",
                        "1",
                        "4.2 kgCO2e",
                        "2026-08-28",
                        "U0002",
                        "ACT-102"
                ));
        return  new ResponseEntity<>(userList,HttpStatus.OK);


    }
    @PatchMapping(value ={"/{userActionId}"},consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void>updateUserAction(@PathVariable String userActionId,@RequestBody UserActionDTO userActionDTO){
        System.out.println("To be updated the user action id : " +userActionId+ "as:" + userActionDTO.toString());
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
    @DeleteMapping(value = {"/{userActionId}"})
    public ResponseEntity<Void>deleteUserAction(@PathVariable String userActionId){
        System.out.println("Deleted user action id : " +userActionId);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
