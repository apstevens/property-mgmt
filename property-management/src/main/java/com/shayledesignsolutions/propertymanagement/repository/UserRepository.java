package com.shayledesignsolutions.propertymanagement.repository;

import com.shayledesignsolutions.propertymanagement.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

  Optional<UserEntity> findByOwnerEmailAndPassword(String email, String password);
  Optional<UserEntity> findByOwnerEmail(String email);

}
