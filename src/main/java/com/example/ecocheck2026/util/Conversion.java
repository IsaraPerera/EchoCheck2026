package com.example.ecocheck2026.util;

import com.example.ecocheck2026.dto.UserDTO;
import com.example.ecocheck2026.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component

@RequiredArgsConstructor
public class Conversion {
    private final ModelMapper mapper;
    //user conversion
    public UserDTO toUserDTO(UserEntity userEntity){
        return mapper.map(userEntity, UserDTO.class);
    }

    public UserEntity toUserEntity(UserDTO userDTO){
        return mapper.map(userDTO, UserEntity.class);
    }
}
