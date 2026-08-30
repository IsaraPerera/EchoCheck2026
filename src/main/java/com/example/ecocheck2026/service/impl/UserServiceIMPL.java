package com.example.ecocheck2026.service.impl;

import com.example.ecocheck2026.dto.UserDTO;
import com.example.ecocheck2026.service.UserService;

import java.util.List;

public class UserServiceIMPL implements UserService {
    @Override
    public void saveUser(UserDTO user) {

    }

    @Override
    public UserDTO getUser(String userId) {
        return null;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return List.of();
    }

    @Override
    public void updateUser(String userId) {

    }

    @Override
    public void delete(String userId, UserDTO user) {

    }

    public void createUser(UserDTO user){
        System.out.println("create user from the service layer :" + user.toString());
    }

}
