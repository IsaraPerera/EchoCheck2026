package com.example.ecocheck2026.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "climate-actions")
@Builder
public class ClimateActionEntity {
    @Id
    private String climateActionId;
    private String title;
    private String description;
    private String estimatedCO2Reduction;
    private int points;

}
