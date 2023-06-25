package com.shayledesignsolutions.propertymanagement.service;

import com.shayledesignsolutions.propertymanagement.dto.UserDTO;

public interface UserService {

  public UserDTO register(UserDTO userDTO);
  public UserDTO login(String email, String password);
}
