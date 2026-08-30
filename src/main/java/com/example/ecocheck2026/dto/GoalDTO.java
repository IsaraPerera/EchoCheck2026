package com.example.ecocheck2026.dto;

import com.example.ecocheck2026.dto.enums.GoalStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GoalDTO {
    private String id;
    private String title;
    private String targetReduction;
    private String targetDate;
    private GoalStatus status;
    private String userId;
}
