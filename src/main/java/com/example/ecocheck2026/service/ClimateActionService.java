package com.example.ecocheck2026.service;

import com.example.ecocheck2026.dto.ClimateActionDTO;

import java.util.List;

public interface ClimateActionService {
    void saveClimateAction(ClimateActionDTO climateAction);
    ClimateActionDTO getSelectedClimateAction(String climateActionId);
    List<ClimateActionDTO> getAllClimateActions();
    void updateClimateAction(String climateActionId, ClimateActionDTO climateAction);
    void deleteClimateAction(String climateActionId);
}
