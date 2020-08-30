package com.smolano.registerproperty.repositories;

import com.smolano.registerproperty.entities.Property;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropertyRepository extends JpaRepository<Property, Long> {
    List<Property> findPropertiesByLeaseValueAndNumberOfRoomsAndArea(double leaseValue, int numberOfRooms, double area);
}
