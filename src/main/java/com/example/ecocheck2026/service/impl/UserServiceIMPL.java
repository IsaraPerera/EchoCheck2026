package com.example.ecocheck2026.service.impl;

import com.example.ecocheck2026.dto.UserDTO;
import com.example.ecocheck2026.dto.enums.Role;
import com.example.ecocheck2026.service.UserService;
import com.example.ecocheck2026.util.IDGenerate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class UserServiceIMPL implements UserService {
    @Override
    public void saveUser(UserDTO user) {
        //generating id
        user.setUserId(IDGenerate.userId());
        //save data


    }

    @Override
    public UserDTO getSelectedUser(String userId) {
        return new UserDTO("U0001","Isara","Perera","isaraperera2005@gmail.com","Issa", Role.ADMIN);

    }

    @Override
    public List<UserDTO> getAllUsers() {
         List<UserDTO> userList= List.of(
                new UserDTO(
                        "U0001",
                        "Isara",
                        "Perera",
                        "isaraperera2005@gmail.com",
                        "Issa",
                        Role.ADMIN
                ),
                new UserDTO(
                        "U0002",
                        "Tusheni",
                        "Perera",
                        "tushi@gmail.com",
                        "tush",
                        Role.ADMIN
                ));
         return userList;
    }

    @Override
    public void updateUser(String userId,UserDTO user) {
        System.out.println("To be updated the userid through service layer: " +userId+ "as:" + user.toString());

    }

    @Override
    public void deleteUser(String userId) {
        System.out.println("Deleted user through service layer user id : " +userId);

    }


}
