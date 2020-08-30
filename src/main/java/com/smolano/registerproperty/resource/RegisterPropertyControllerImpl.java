package com.smolano.registerproperty.resource;

import com.smolano.registerproperty.entities.Property;
import com.smolano.registerproperty.service.IRegisterProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class IRegisterPropertyControllerImpl implements IRegisterPropertyController {
    @Autowired
    private IRegisterProperty iRegisterProperty;

    @Override
    public ResponseEntity<Property> registerProperty(URI location, @Valid Property property) {
        iRegisterProperty.registerProperty(property);
        return ResponseEntity.created(location).body(property);
    }

    @Override
    public ResponseEntity<List<Property>> getProperties(double leaseValue, int numberOfRooms, double area) {
        return ResponseEntity.ok(iRegisterProperty.getPropertiesByLeaseValueAndNumberOfRoomsAndArea(leaseValue, numberOfRooms, area));
    }
}
