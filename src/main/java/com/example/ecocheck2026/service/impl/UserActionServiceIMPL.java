package com.example.ecocheck2026.service.impl;

import com.example.ecocheck2026.dao.ClimateActionDAO;
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
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
public class UserActionServiceIMPL implements UserActionService {
    private final UserActionDAO userActionDAO;
    private final Conversion conversion;
    private final UserDAO userDAO;
    private final ClimateActionDAO climateActionDAO;

    @Override
    public void saveUserAction(UserActionDTO userAction) {
        userAction.setClimateActionId(IDGenerate.userActionId());
        userActionDAO.save(conversion.toUserActionEntity(userAction));
    }

    @Override
    public UserActionDTO getSelectedUserAction(String userActionId) {
        UserActionEntity userActionEntity = userActionDAO.findById(userActionId)
                .orElseThrow(() ->new DataNotFoundException("UserAction not Found"));
        return conversion.toUserActionDTO(userActionEntity);
    }

    @Override
    public List<UserActionDTO> getAllUserActions() {
        return conversion.toUserActionDTOList(userActionDAO.findAll());
    }

    @Override
    public void updateUserAction(String userActionId, UserActionDTO userActionDTO) {
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
        UserActionEntity foundUserAction = userActionDAO.findById(userActionId)
                .orElseThrow(()->new DataNotFoundException("user not found"));
        userActionDAO.delete(foundUserAction);
    }
}
