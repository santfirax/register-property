package com.smolano.registerproperty.resource;

import com.smolano.registerproperty.entities.Property;
import com.smolano.registerproperty.model.PropertyDTO;
import com.smolano.registerproperty.service.IRegisterProperty;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
public class RegisterPropertyControllerImpl implements IRegisterPropertyController {
    @Autowired
    private IRegisterProperty iRegisterProperty;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public ResponseEntity<Property> registerProperty(URI location, PropertyDTO propertyDTO) {
        Property property = this.modelMapper.map(propertyDTO, Property.class);
        iRegisterProperty.registerProperty(property);
        return ResponseEntity.created(location).body(property);
    }

    @Override
    public ResponseEntity<List<Property>> getProperties(double leaseValue, int numberOfRooms, double area) {
        return ResponseEntity.ok(iRegisterProperty.getPropertiesByLeaseValueAndNumberOfRoomsAndArea(leaseValue, numberOfRooms, area));
    }
}
