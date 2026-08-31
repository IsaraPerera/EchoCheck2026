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
@Table(name = "user-actions")
@Builder
public class UserActionEntity {
    @Id
    private String userActionId;
    private String quantity;
    private String totalReduction;
    private String completedDate;
    private String userId;
    private String actionId;
}
