package com.example.ecocheck2026.service.impl;

import com.example.ecocheck2026.dto.UserActionDTO;
import com.example.ecocheck2026.service.UserActionService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserActionServiceIMPL implements UserActionService {
    @Override
    public void saveUserAction(UserActionDTO userAction) {
        System.out.println("create user action :" + userAction.toString());
    }

    @Override
    public UserActionDTO getSelectedUserAction(String userActionId) {
        System.out.println("selected user action :" + userActionId);
        return new UserActionDTO("UA-901","3","37.5 kgCO2e","2026-08-15","U0001", "ACT-101");
    }

    @Override
    public List<UserActionDTO> getAllUserActions() {
        List<UserActionDTO> userActionList= List.of(
                new UserActionDTO(
                        "UA-901",
                        "3",
                        "37.5 kgCO2e",
                        "2026-08-15",
                        "U0001",
                        "ACT-101"
                ),
                new UserActionDTO(
                        "UA-902",
                        "1",
                        "4.2 kgCO2e",
                        "2026-08-28",
                        "U0002",
                        "ACT-102"
                ));
        return userActionList;
    }

    @Override
    public void updateUserAction(String userActionId, UserActionDTO userAction) {
        System.out.println("To be updated the user action id : " +userActionId+ "as:" + userAction.toString());
    }

    @Override
    public void deleteUserAction(String userActionId) {
        System.out.println("Deleted user action id : " +userActionId);
    }
}
