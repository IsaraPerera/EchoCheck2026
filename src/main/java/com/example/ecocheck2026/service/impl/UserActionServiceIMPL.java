package com.example.ecocheck2026.service.impl;

import com.example.ecocheck2026.dao.UserActionDAO;
import com.example.ecocheck2026.dao.UserDAO;
import com.example.ecocheck2026.dto.UserActionDTO;
import com.example.ecocheck2026.entity.ClimateActionEntity;
import com.example.ecocheck2026.entity.UserActionEntity;
import com.example.ecocheck2026.entity.UserEntity;
import com.example.ecocheck2026.exceptions.DataNotFoundException;
import com.example.ecocheck2026.service.UserActionService;
import com.example.ecocheck2026.util.Conversion;
import com.example.ecocheck2026.util.IDGenerate;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
public class UserActionServiceIMPL implements UserActionService {

    private final Conversion conversion;
    private final UserActionDAO userActionDAO;
    private final UserDAO userDAO;

    @Override
    public void saveUserAction(UserActionDTO userAction) {
        userAction.setActionId(IDGenerate.userActionId());
        UserActionEntity userActionEntity = conversion.toUserActionEntity(userAction);
        userActionDAO.save(userActionEntity);
    }

    @Override
    public UserActionDTO getSelectedUserAction(String userActionId) throws ChangeSetPersister.NotFoundException {
        UserActionEntity userActionEntity = userActionDAO.findById(userActionId)
                .orElseThrow(() -> new DataNotFoundException("User Action Not Found"));
        return conversion.toUserActionDTO(userActionEntity);
    }

    @Override
    public List<UserActionDTO> getAllUserActions() {
        return conversion.toUserActionDTOList(userActionDAO.findAll());
    }

    @Override
    public void updateUserAction(String userActionId, UserActionDTO userAction) {
        UserEntity foundUserEntity = userDAO.findById(userActionDTO.getUserId())
                .orElseThrow(() -> new DataNotFoundException("User Not Found"));
        ClimateActionEntity foundClimateActionEntity = climateActionDAO.findById(userActionDTO.getClimateActionId())
                .orElseThrow(() -> new DataNotFoundException("Climate Action Not Found"));
        UserActionEntity foundUserActionEntity = userActionDAO.findById(userActionId)
                .orElseThrow(() -> new DataNotFoundException("User Action Not Found"));

        foundUserActionEntity.setClimateAction(foundClimateActionEntity);
        foundUserActionEntity.setUser(foundUserEntity);
        foundUserActionEntity.setQuantity(userActionDTO.getQuantity());
        foundUserActionEntity.setTotalReduction(userActionDTO.getTotalReduction());

    }

    @Override
    public void deleteUserAction(String userActionId) {
        System.out.println("Deleted user action id : " +userActionId);
    }
}
