package com.example.ecocheck2026.controller;

import com.example.ecocheck2026.dto.GoalDTO;
import com.example.ecocheck2026.dto.enums.GoalStatus;
import com.example.ecocheck2026.dto.enums.Role;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/goals")
public class goalController {
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createGoal(@RequestBody GoalDTO goalDTO){
        System.out.println("create goal:" + goalDTO.toString());
        return  new ResponseEntity<>(HttpStatus.CREATED);

    }
    @GetMapping(value ={"/{goalId}"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GoalDTO>getSelectedGoal(@PathVariable String goalId){
        System.out.println("selected goal:" + goalId);
        return  new ResponseEntity<>(new GoalDTO("GOAL-501","Reduce monthly carbon footprint","50.0 kgCO2e","2026-12-31", GoalStatus.ACTIVE, "U0001"),HttpStatus.OK);

    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GoalDTO>>getGoals(){
        List<GoalDTO> goalList= List.of(
                new GoalDTO(
                        "GOAL-501",
                        "Reduce monthly carbon footprint",
                        "50.0 kgCO2e",
                        "2026-12-31",
                        GoalStatus.ACTIVE,
                        "U0001"
                ),
                new GoalDTO(
                        "GOAL-502",
                        "Zero Waste Month",
                        "25.5 kgCO2e",
                        "2026-09-30",
                        GoalStatus.COMPLETED,
                        "U0002"
                ));
        return  new ResponseEntity<>(goalList,HttpStatus.OK);


    }
    @PatchMapping(value ={"/{goalId}"},consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void>updateGoal(@PathVariable String goalId,@RequestBody GoalDTO goalDTO){
        System.out.println("To be updated the goal id : " +goalId+ "as:" + goalDTO.toString());
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
    @DeleteMapping(value = {"/{goalId}"})
    public ResponseEntity<Void>deleteGoal(@PathVariable String goalId){
        System.out.println("Deleted goal id : " +goalId);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
