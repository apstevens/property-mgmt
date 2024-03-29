package com.shayledesignsolutions.propertymanagement.controller;

import com.shayledesignsolutions.propertymanagement.dto.UserDTO;
import com.shayledesignsolutions.propertymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

  @Autowired
  private UserService userService;
  @PostMapping("/register")
  public ResponseEntity<UserDTO> saveUser(@Valid @RequestBody UserDTO userDTO) {
    userDTO = userService.register(userDTO);
    return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
  }

  @PostMapping("/login")
  public ResponseEntity<UserDTO> login(@RequestBody UserDTO userDTO) {
    userDTO = userService.login(userDTO.getOwnerEmail(), userDTO.getPassword());
    return new ResponseEntity<>(userDTO, HttpStatus.OK);
  }
}
