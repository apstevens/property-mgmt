package com.shayledesignsolutions.propertymanagement.repository;

import com.shayledesignsolutions.propertymanagement.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

}
