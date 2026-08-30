package com.example.ecocheck2026.service;

import com.example.ecocheck2026.dto.ActionCategoryDTO;
import com.example.ecocheck2026.dto.UserDTO;

import java.util.List;

public interface ActionCategoryService {
    void createActionCategory(ActionCategoryDTO actionCategory);
    ActionCategoryDTO getSelectedActionCategory(String actionCategoryId);
    List<ActionCategoryDTO> getActionCategories();
    void updateActionCategory(String actionCategoryId, ActionCategoryDTO actionCategory);
    void deleteActionCategory(String actionCategoryId);
}
