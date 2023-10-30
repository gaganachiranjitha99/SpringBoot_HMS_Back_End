package com.rhms.hms_backend.Controllers;

import com.rhms.hms_backend.Models.Hostals;
import com.rhms.hms_backend.Models.Property;
import com.rhms.hms_backend.Services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/property")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @PostMapping("/create")
    public ResponseEntity<Property> createProperty(@RequestBody Property property) {
        Property createdProperty = propertyService.createProperty(property);
        return new ResponseEntity<>(createdProperty, HttpStatus.CREATED);
    }

    @GetMapping("/allproperty")
    public List<Property> getAllProperty() {
        return propertyService.getAllProperty();
    }
}
