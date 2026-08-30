package com.example.ecocheck2026.service;

import com.example.ecocheck2026.dto.UserDTO;

import java.util.List;

public interface UserService {
    void saveUser(UserDTO user);
    UserDTO getUser(String userId);
    List<UserDTO> getAllUsers();
    void updateUser(String userId);
    void delete(String userId, UserDTO user);
}
