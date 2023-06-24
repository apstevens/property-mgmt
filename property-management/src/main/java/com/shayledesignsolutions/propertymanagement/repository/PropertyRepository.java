package com.shayledesignsolutions.propertymanagement.repository;

import com.shayledesignsolutions.propertymanagement.entity.PropertyEntity;
import org.springframework.data.repository.CrudRepository;

public interface PropertyRepository extends CrudRepository<PropertyEntity, Long> {

}
