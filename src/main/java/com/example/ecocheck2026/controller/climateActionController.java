package com.example.ecocheck2026.controller;

import com.example.ecocheck2026.dto.ClimateActionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/climateaction")
@RestController
public class climateActionController {
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createClimateAction(@RequestBody ClimateActionDTO climateActionDTO){
        System.out.println("create climate action:" + climateActionDTO.toString());
        return  new ResponseEntity<>(HttpStatus.CREATED);

    }
    @GetMapping(value ={"/{climateActionId}"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClimateActionDTO>getSelectedClimateAction(@PathVariable String climateActionId){
        System.out.println("selected climate action:" + climateActionId);
        return  new ResponseEntity<>(new ClimateActionDTO("CA0001","LED Bulbs","Replace old incandescent bulbs with energy-efficient LEDs","12.5 kgCO2e",50),HttpStatus.OK);

    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClimateActionDTO>>getActionCategories(){
        List<ClimateActionDTO> climateactionList= List.of(
                new ClimateActionDTO(
                        "CA0001",
                        "LED Bulbs",
                        "Replace old incandescent bulbs with energy-efficient LEDs",
                        "12.5 kgCO2e",
                        50
                ),
                new ClimateActionDTO(
                        "CA0002",
                        "Biking",
                        "Try Cycling instead of using a car",
                        "4.2 kgCO2e",
                        100));
        return  new ResponseEntity<>(climateactionList,HttpStatus.OK);


    }
    @PatchMapping(value ={"/{climateActionId}"},consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void>updateClimateAction(@PathVariable String climateActionId,@RequestBody ClimateActionDTO climateActionDTO){
        System.out.println("To be updated the climate action id : " +climateActionId+ "as:" + climateActionDTO.toString());
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
    @DeleteMapping(value = {"/{climateActionId}"})
    public ResponseEntity<Void>deleteClimateAction(@PathVariable String climateActionId){
        System.out.println("Deleted climate action id : " +climateActionId);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
