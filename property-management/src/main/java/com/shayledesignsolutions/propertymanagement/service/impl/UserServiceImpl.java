package com.shayledesignsolutions.propertymanagement.service.impl;

import com.shayledesignsolutions.propertymanagement.converter.UserConverter;
import com.shayledesignsolutions.propertymanagement.dto.UserDTO;
import com.shayledesignsolutions.propertymanagement.entity.UserEntity;
import com.shayledesignsolutions.propertymanagement.repository.UserRepository;
import com.shayledesignsolutions.propertymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private UserConverter userConverter;

  @Override
  public UserDTO register(UserDTO userDTO) {
    UserEntity userEntity = userConverter.convertDTOtoEntity(userDTO);
    userEntity = userRepository.save(userEntity);
    userDTO = userConverter.convertEntityToDTO(userEntity);
    return userDTO;
  }

  @Override
  public UserDTO login(String email, String password) {
    return null;
  }
}
