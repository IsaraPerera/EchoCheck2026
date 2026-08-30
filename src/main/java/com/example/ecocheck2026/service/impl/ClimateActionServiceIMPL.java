package com.example.ecocheck2026.service.impl;

import com.example.ecocheck2026.dto.ClimateActionDTO;
import com.example.ecocheck2026.service.ClimateActionService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClimateActionServiceIMPL implements ClimateActionService {
    @Override
    public void saveClimateAction(ClimateActionDTO climateAction) {
        System.out.println("create climate action:" + climateAction.toString());
    }

    @Override
    public ClimateActionDTO getSelectedClimateAction(String climateActionId) {
        return new ClimateActionDTO("CA0001","LED Bulbs","Replace old incandescent bulbs with energy-efficient LEDs","12.5 kgCO2e",50);
    }

    @Override
    public List<ClimateActionDTO> getAllClimateActions() {
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
        return climateactionList;
    }

    @Override
    public void updateClimateAction(String climateActionId, ClimateActionDTO climateAction) {
        System.out.println("To be updated the climate action id : " +climateActionId+ "as:" + climateAction.toString());

    }

    @Override
    public void deleteClimateAction(String climateActionId) {
        System.out.println("Deleted climate action id : " +climateActionId);

    }
}
