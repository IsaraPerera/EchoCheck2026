package com.example.ecocheck2026.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserActionDTO {
    private String userActionId;
    private String quantity;
    private String totalReduction;
    private String completedDate;
    private String userId;
    private String actionId;
}
