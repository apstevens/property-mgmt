package com.shayledesignsolutions.propertymanagement.service.impl;

import com.shayledesignsolutions.propertymanagement.converter.PropertyConverter;
import com.shayledesignsolutions.propertymanagement.dto.PropertyDTO;
import com.shayledesignsolutions.propertymanagement.entity.PropertyEntity;
import com.shayledesignsolutions.propertymanagement.repository.PropertyRepository;
import com.shayledesignsolutions.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {

  @Autowired
  private PropertyRepository propertyRepository;
  @Autowired
  private PropertyConverter propertyConverter;

  @Override
  public PropertyDTO saveProperty(PropertyDTO propertyDTO) {

    PropertyEntity pe = propertyConverter.convertDTOtoEntity(propertyDTO);

    pe = propertyRepository.save(pe);

    propertyDTO = propertyConverter.convertEntityToDTO(pe);

    return propertyDTO;
  }

  @Override
  public List<PropertyDTO> getAllProperties() {
    List<PropertyEntity> listOfProperties = (List<PropertyEntity>) propertyRepository.findAll();
    List<PropertyDTO> propList = new ArrayList<>();
    for (PropertyEntity pe : listOfProperties) {
      PropertyDTO dto = propertyConverter.convertEntityToDTO(pe);
      propList.add(dto);
    }
    return propList;
  }

  @Override
  public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId) {
    Optional<PropertyEntity> optEnt = propertyRepository.findById(propertyId);
    PropertyDTO dto = null;
    if (optEnt.isPresent()) {
      PropertyEntity pe = optEnt.get();
      pe.setTitle(propertyDTO.getTitle());
      pe.setDescription(propertyDTO.getDescription());
      pe.setOwnerName(propertyDTO.getOwnerName());
      pe.setOwnerEmail(propertyDTO.getOwnerEmail());
      pe.setAddress(propertyDTO.getAddress());
      pe.setPrice(propertyDTO.getPrice());
      dto = propertyConverter.convertEntityToDTO(pe);
      propertyRepository.save(pe);
    }
    return dto;
  }

  @Override
  public PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long propertyId) {
    Optional<PropertyEntity> optEnt = propertyRepository.findById(propertyId);
    PropertyDTO dto = null;
    if (optEnt.isPresent()) {
      PropertyEntity pe = optEnt.get();
      pe.setDescription(propertyDTO.getDescription());
      dto = propertyConverter.convertEntityToDTO(pe);
      propertyRepository.save(pe);
    }
    return dto;
  }

  @Override
  public PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long propertyId) {
    Optional<PropertyEntity> optEnt = propertyRepository.findById(propertyId);
    PropertyDTO dto = null;
    if (optEnt.isPresent()) {
      PropertyEntity pe = optEnt.get();
      pe.setPrice(propertyDTO.getPrice());
      dto = propertyConverter.convertEntityToDTO(pe);
      propertyRepository.save(pe);
    }
    return dto;
  }

  @Override
  public void deleteProperty(Long propertyId) {
    propertyRepository.deleteById(propertyId);
  }
}
