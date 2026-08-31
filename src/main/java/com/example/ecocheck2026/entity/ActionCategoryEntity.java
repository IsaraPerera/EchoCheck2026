package com.example.ecocheck2026.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ActionCategoryEntity implements Serializable {
    private String categoryId;
    private String name;
    private String description;
}
