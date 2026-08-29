package com.example.ecocheck2026.controller;

import com.example.ecocheck2026.dto.ActionCategoryDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/actioncategory")
@RestController
public class actionCategoryController {
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createActionCategory(@RequestBody ActionCategoryDTO actionCategoryDTO){
        System.out.println("create action category:" + actionCategoryDTO.toString());
        return  new ResponseEntity<>(HttpStatus.CREATED);

    }
    @GetMapping(value ={"/{actionCategoryId}"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ActionCategoryDTO>getSelectedActionCategory(@PathVariable String actionCategoryId){
        System.out.println("selected action category:" + actionCategoryId);
        return  new ResponseEntity<>(new ActionCategoryDTO("C0001","category 1","Plants"),HttpStatus.OK);

    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ActionCategoryDTO>>getActionCategories(){
        List<ActionCategoryDTO> actioncategoryList= List.of(
                new ActionCategoryDTO(
                        "C0001",
                        "category 1",
                        "Plants"
                ),
                new ActionCategoryDTO(
                        "C0002",
                        "category 2",
                        "Co2 emission"
                ));
        return  new ResponseEntity<>(actioncategoryList,HttpStatus.OK);


    }
    @PatchMapping(value ={"/{actionCategoryId}"},consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void>updateActionCategory(@PathVariable String actionCategoryId,@RequestBody ActionCategoryDTO actionCategoryDTO){
        System.out.println("To be updated the action categoryid : " +actionCategoryId+ "as:" + actionCategoryDTO.toString());
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
    @DeleteMapping(value = {"/{actionCategoryId}"})
    public ResponseEntity<Void>deleteActionCategory(@PathVariable String actionCategoryId){
        System.out.println("Deleted action category id : " +actionCategoryId);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
