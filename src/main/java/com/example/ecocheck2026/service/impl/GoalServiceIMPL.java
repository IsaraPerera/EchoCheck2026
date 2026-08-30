package com.example.ecocheck2026.service.impl;

import com.example.ecocheck2026.dto.GoalDTO;
import com.example.ecocheck2026.dto.enums.GoalStatus;
import com.example.ecocheck2026.service.GoalService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalServiceIMPL implements GoalService {
    @Override
    public void saveGoal(GoalDTO goal) {
        System.out.println("create goal:" + goal.toString());

    }

    @Override
    public GoalDTO getSelectedGoal(String goalId) {
        System.out.println("selected goal:" + goalId);
        return new GoalDTO("GOAL-501","Reduce monthly carbon footprint","50.0 kgCO2e","2026-12-31", GoalStatus.ACTIVE, "U0001");
    }

    @Override
    public List<GoalDTO> getAllGoals() {
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
        return goalList;
    }

    @Override
    public void updateGoal(String goalId, GoalDTO goal) {
        System.out.println("To be updated the goal id : " +goalId+ "as:" + goal.toString());
    }

    @Override
    public void deleteGoal(String goalId) {
        System.out.println("Deleted goal id : " +goalId);
    }
}
