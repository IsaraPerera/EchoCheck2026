package com.example.ecocheck2026.service.impl;

import com.example.ecocheck2026.dao.ActionCategoryDAO;
import com.example.ecocheck2026.dao.ClimateActionDAO;
import com.example.ecocheck2026.dto.ClimateActionDTO;
import com.example.ecocheck2026.entity.ActionCategoryEntity;
import com.example.ecocheck2026.entity.ClimateActionEntity;
import com.example.ecocheck2026.entity.UserEntity;
import com.example.ecocheck2026.exceptions.DataNotFoundException;
import com.example.ecocheck2026.service.ClimateActionService;
import com.example.ecocheck2026.util.Conversion;
import com.example.ecocheck2026.util.IDGenerate;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Transactional
@RequiredArgsConstructor
@Service
public class ClimateActionServiceIMPL implements ClimateActionService {
    private final ClimateActionDAO climateActionDAO;
    private final Conversion conversion;
    private final ActionCategoryDAO actionCategoryDAO;


    @Override
    public void saveClimateAction(ClimateActionDTO climateAction) {
        climateAction.setClimateActionId(IDGenerate.climateActionId());
        ClimateActionEntity climateEntity = conversion.toClimateActionEntity(climateAction);
        climateActionDAO.save(conversion.toClimateActionEntity(climateAction));
    }

    @Override
    public ClimateActionDTO getSelectedClimateAction(String climateActionId) {
        ClimateActionEntity climateActionEntity = climateActionDAO.findById(climateActionId)
                .orElseThrow(() ->new DataNotFoundException("ClimateAction not Found"));
        return conversion.toClimateActionDTO(climateActionEntity);

    }

    @Override
    public List<ClimateActionDTO> getAllClimateActions() {
        return conversion.toClimateActionDTOList(climateActionDAO.findAll());
    }

    @Override
    public void updateClimateAction(String climateActionId, ClimateActionDTO climateActionDTO) {
        ActionCategoryEntity foundActionCategory = actionCategoryDAO.findById(climateActionDTO.getClimateActionId())
                .orElseThrow(() -> new DataNotFoundException("ActionCategory not found"));

        ClimateActionEntity foundClimateAction = climateActionDAO.findById(climateActionId)
                .orElseThrow(() -> new DataNotFoundException("Climate Action Not Found"));

        foundClimateAction.setActionCategory(foundActionCategory);
        foundClimateAction.setTitle(climateActionDTO.getTitle());
        foundClimateAction.setDescription(climateActionDTO.getDescription());
        foundClimateAction.setPoints(climateActionDTO.getPoints());
        foundClimateAction.setEstimatedCO2Reduction(climateActionDTO.getEstimatedCO2Reduction());

    }

    @Override
    public void deleteClimateAction(String climateActionId) {
        ClimateActionEntity foundClimateAction = climateActionDAO.findById(climateActionId)
                .orElseThrow(()->new DataNotFoundException("climateAction not found"));
        climateActionDAO.delete(foundClimateAction);
    }
}
