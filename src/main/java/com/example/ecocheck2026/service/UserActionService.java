package com.example.ecocheck2026.service;

import com.example.ecocheck2026.dto.UserActionDTO;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;


public interface UserActionService {
    void saveUserAction(UserActionDTO userAction);
    UserActionDTO getSelectedUserAction(String userActionId) throws ChangeSetPersister.NotFoundException;
    List<UserActionDTO> getAllUserActions();
    void updateUserAction(String userActionId, UserActionDTO userAction);
    void deleteUserAction(String userActionId);
}
