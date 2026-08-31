package com.example.ecocheck2026.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClimateActionEntity {
    private String climateActionId;
    private String title;
    private String description;
    private String estimatedCO2Reduction;
    private int points;

}
