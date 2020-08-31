package com.smolano.registerproperty.resource;

import com.smolano.registerproperty.entities.Property;
import com.smolano.registerproperty.model.PropertyDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequestMapping("/property")
public interface IRegisterPropertyController {
    @PostMapping()
    ResponseEntity<Property> registerProperty(URI location, @RequestBody PropertyDTO propertyDTO);

    @GetMapping
    ResponseEntity<List<Property>> getProperties(@RequestParam double leaseValue, @RequestParam int numberOfRooms, @RequestParam double area);

}
