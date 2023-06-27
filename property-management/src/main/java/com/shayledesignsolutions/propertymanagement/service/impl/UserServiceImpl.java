package com.shayledesignsolutions.propertymanagement.service.impl;

import com.shayledesignsolutions.propertymanagement.converter.UserConverter;
import com.shayledesignsolutions.propertymanagement.dto.UserDTO;
import com.shayledesignsolutions.propertymanagement.entity.UserEntity;
import com.shayledesignsolutions.propertymanagement.exception.BusinessException;
import com.shayledesignsolutions.propertymanagement.exception.ErrorModel;
import com.shayledesignsolutions.propertymanagement.repository.UserRepository;
import com.shayledesignsolutions.propertymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private UserConverter userConverter;

  @Override
  public UserDTO register(UserDTO userDTO) {
    Optional<UserEntity> optUe = userRepository.findByOwnerEmail(userDTO.getOwnerEmail());
    if (optUe.isPresent()) {
      List<ErrorModel> errorModelList = new ArrayList<>();
      ErrorModel errorModel = new ErrorModel();
      errorModel.setCode("EMAIL_ALREADY_EXISTS");
      errorModel.setMessage("The email you are trying to register with already exists");
      errorModelList.add(errorModel);

      throw new BusinessException(errorModelList);
    }
    UserEntity userEntity = userConverter.convertDTOtoEntity(userDTO);
    userEntity = userRepository.save(userEntity);
    userDTO = userConverter.convertEntityToDTO(userEntity);
    return userDTO;
  }

  @Override
  public UserDTO login(String email, String password) {
    UserDTO userDTO = null;
    Optional<UserEntity> optionalUserEntity = userRepository.findByOwnerEmailAndPassword(email,
        password);
    if (optionalUserEntity.isPresent()) {
      userDTO = userConverter.convertEntityToDTO(optionalUserEntity.get());
    } else {
      List<ErrorModel> errorModelList = new ArrayList<>();
      ErrorModel errorModel = new ErrorModel();
      errorModel.setCode("INVALID_LOGIN");
      errorModel.setMessage("Incorrect Email or password");
      errorModelList.add(errorModel);

      throw new BusinessException(errorModelList);
    }
    return userDTO;
  }
}
