package com.example.ecocheck2026.service.impl;

import com.example.ecocheck2026.dao.ActionCategoryDAO;
import com.example.ecocheck2026.dto.ActionCategoryDTO;
import com.example.ecocheck2026.entity.ActionCategoryEntity;
import com.example.ecocheck2026.entity.UserEntity;
import com.example.ecocheck2026.exceptions.DataNotFoundException;
import com.example.ecocheck2026.service.ActionCategoryService;
import com.example.ecocheck2026.util.Conversion;
import com.example.ecocheck2026.util.IDGenerate;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Transactional
@RequiredArgsConstructor
@Service
public class ActionCategoryServiceIMPL implements ActionCategoryService {
    private final Conversion conversion;
    private final ActionCategoryDAO actionCategoryDAO;
    @Override
    public void createActionCategory(ActionCategoryDTO actionCategory) {
        actionCategory.setCategoryId(IDGenerate.actionCategoryId());
        //save data
        ActionCategoryEntity actionCategoryEntity = conversion.toActionCategoryEntity(actionCategory);
        actionCategoryDAO.save(conversion.toActionCategoryEntity(actionCategory));
    }

    @Override
    public ActionCategoryDTO getSelectedActionCategory(String actionCategoryId) {
        ActionCategoryEntity actionCategoryEntity = actionCategoryDAO.findById(actionCategoryId)
                .orElseThrow(() ->new DataNotFoundException("ActionCategory not Found"));
        return conversion.toActionCategoryDTO(actionCategoryEntity);
    }

    @Override
    public List<ActionCategoryDTO> getActionCategories() {
        return conversion.actionCategoryDTOList(actionCategoryDAO.findAll());
    }

    @Override
    public void updateActionCategory(String actionCategoryId, ActionCategoryDTO actionCategory) {
        ActionCategoryEntity foundActionCategory= actionCategoryDAO.findById(actionCategoryId)
                .orElseThrow(() -> new DataNotFoundException("Action Category Not Found"));

        foundActionCategory.setName(actionCategory.getName());
        foundActionCategory.setDescription(actionCategory.getDescription());

    }

    @Override
    public void deleteActionCategory(String actionCategoryId) {
        ActionCategoryEntity foundActionCategory = actionCategoryDAO.findById(actionCategoryId)
                .orElseThrow(()->new DataNotFoundException("actionCategory not found"));
        actionCategoryDAO.delete(foundActionCategory);

    }
}
