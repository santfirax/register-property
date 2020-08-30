package com.smolano.registerproperty.service;

import com.smolano.registerproperty.entities.Property;
import com.smolano.registerproperty.repositories.PropertyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterPropertyImpl implements IRegisterProperty {
    private static final Logger LOGGER = LoggerFactory.getLogger(RegisterPropertyImpl.class);
    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    public void registerProperty(Property property) {
        LOGGER.info("Creating property:{} in database", property);
        propertyRepository.saveAndFlush(property);
    }

    @Override
    public List<Property> getAllProperties() {
        return null;
    }

    @Override
    public List<Property> getPropertiesByLeaseValueAndNumberOfRoomsAndArea(double leaseValue, int numberOfRooms, double area) {
        LOGGER.info("Getting all properties by values {}", leaseValue);
        return propertyRepository.findPropertiesByLeaseValueAndNumberOfRoomsAndArea(leaseValue, numberOfRooms, area);
    }
}
