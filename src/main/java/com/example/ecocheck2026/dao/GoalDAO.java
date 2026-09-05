package com.example.ecocheck2026.dao;

import com.example.ecocheck2026.entity.GoalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalDAO extends JpaRepository<GoalEntity, String> {
}
