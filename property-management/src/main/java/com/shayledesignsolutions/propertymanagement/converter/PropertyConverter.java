package com.shayledesignsolutions.propertymanagement.converter;

import com.shayledesignsolutions.propertymanagement.dto.PropertyDTO;
import com.shayledesignsolutions.propertymanagement.entity.PropertyEntity;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {

  public PropertyEntity convertDTOtoEntity(PropertyDTO propertyDTO) {
    PropertyEntity pe = new PropertyEntity();
    pe.setTitle(propertyDTO.getTitle());
    pe.setDescription(propertyDTO.getDescription());
    pe.setAddress(propertyDTO.getAddress());
    pe.setPrice(propertyDTO.getPrice());

    return pe;
  }

  public PropertyDTO convertEntityToDTO(PropertyEntity propertyEntity) {
    PropertyDTO propertyDTO = new PropertyDTO();
    propertyDTO.setId(propertyEntity.getId());
    propertyDTO.setTitle(propertyEntity.getTitle());
    propertyDTO.setDescription(propertyEntity.getDescription());
    propertyDTO.setPrice(propertyEntity.getPrice());
    propertyDTO.setAddress(propertyEntity.getAddress());

    return propertyDTO;

  }
}
