package com.shayledesignsolutions.propertymanagement.converter;

import com.shayledesignsolutions.propertymanagement.dto.UserDTO;
import com.shayledesignsolutions.propertymanagement.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

  public UserEntity convertDTOtoEntity(UserDTO userDTO) {
    UserEntity userEntity = new UserEntity();
    userEntity.setOwnerEmail(userDTO.getOwnerEmail());
    userEntity.setOwnerName(userDTO.getOwnerName());
    userEntity.setPassword(userDTO.getPassword());
    userEntity.setPhone(userDTO.getPhone());
    return userEntity;
  }

  public UserDTO convertEntityToDTO(UserEntity userEntity) {
    UserDTO userDTO = new UserDTO();
    userDTO.setId(userEntity.getId());
    userDTO.setOwnerEmail(userEntity.getOwnerEmail());
    userDTO.setOwnerName(userEntity.getOwnerName());
    userDTO.setPhone(userEntity.getPhone());
    return userDTO;
  }
}
