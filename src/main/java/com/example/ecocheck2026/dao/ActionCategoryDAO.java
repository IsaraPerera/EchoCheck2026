package com.example.ecocheck2026.dao;

import com.example.ecocheck2026.entity.ActionCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionCategoryDAO extends JpaRepository<ActionCategoryEntity, String> {

}
