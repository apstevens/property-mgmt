package com.shayledesignsolutions.propertymanagement.service;

import com.shayledesignsolutions.propertymanagement.dto.PropertyDTO;

import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PropertyService {

  PropertyDTO saveProperty(PropertyDTO propertyDTO);
  List<PropertyDTO> getAllProperties();
  PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId);
  PropertyDTO updatePropertyDescription(@RequestBody PropertyDTO propertyDTO, Long propertyId);
  PropertyDTO updatePropertyPrice(@RequestBody PropertyDTO propertyDTO, Long propertyId);
  void deleteProperty(Long propertyId);
}
