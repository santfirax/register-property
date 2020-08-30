package com.smolano.registerproperty.service;

import com.smolano.registerproperty.entities.Property;

import java.util.List;


public interface IRegisterProperty {
    void registerProperty(Property property);

    List<Property> getAllProperties();

    List<Property> getPropertiesByLeaseValueAndNumberOfRoomsAndArea(double leaseValue, int numberOfRooms, double area);
}
