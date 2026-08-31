package com.example.ecocheck2026.entity;

import com.example.ecocheck2026.dto.enums.GoalStatus;
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
@Table(name="goals")
@Builder
public class GoalEntity {
    @Id
    private String id;
    private String title;
    private String targetReduction;
    private String targetDate;
    private GoalStatus status;
    private String userId;
}
