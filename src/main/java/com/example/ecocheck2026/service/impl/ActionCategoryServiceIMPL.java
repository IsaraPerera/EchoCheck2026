package com.example.ecocheck2026.service.impl;

import com.example.ecocheck2026.dto.ActionCategoryDTO;
import com.example.ecocheck2026.service.ActionCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ActionCategoryServiceIMPL implements ActionCategoryService {
    @Override
    public void createActionCategory(ActionCategoryDTO actionCategory) {
        System.out.println("create action category:" + actionCategory.toString());

    }

    @Override
    public ActionCategoryDTO getSelectedActionCategory(String actionCategoryId) {
        System.out.println("selected action category:" + actionCategoryId);

        return new ActionCategoryDTO("C0001","category 1","Plants");
    }

    @Override
    public List<ActionCategoryDTO> getActionCategories() {
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
        return actioncategoryList;
    }

    @Override
    public void updateActionCategory(String actionCategoryId, ActionCategoryDTO actionCategory) {
        System.out.println("To be updated the action category id : " +actionCategoryId+ "as:" + actionCategory.toString());

    }

    @Override
    public void deleteActionCategory(String actionCategoryId) {
        System.out.println("Deleted action category id : " +actionCategoryId);

    }
}
