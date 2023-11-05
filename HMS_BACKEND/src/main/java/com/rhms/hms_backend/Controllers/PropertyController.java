package com.rhms.hms_backend.Controllers;

import com.rhms.hms_backend.Models.Properties;
import com.rhms.hms_backend.Models.PropertyView;
import com.rhms.hms_backend.Services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/property")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

//    @PostMapping("/create")
//    public ResponseEntity<Property> createProperty(@RequestBody Property property) {
//        Property createdProperty = propertyService.createProperty(property);
//        return new ResponseEntity<>(createdProperty, HttpStatus.CREATED);
//    }

    @PostMapping("/create")
    public ResponseEntity<String> insertProperty(@RequestBody Properties properties) {
        try {
            propertyService.insertProperty(properties.getC_itemcode(), properties.getName(), properties.getStatus());
            return new ResponseEntity<>("Property insert successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to insert property: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @GetMapping("/allproperty")
//    public List<Property> getAllProperty() {
//        return propertyService.getAllProperty();
//    }

    @GetMapping("/allproperty")
    public List<Properties> getPropertyView() {
        return propertyService.getPropertiesView();
    }

    @GetMapping("/oneproperty/{proid}")
    public Optional<PropertyView> getPropertyById(@PathVariable Long proid) {
        return propertyService.getPropertyById(proid);
    }

    @GetMapping("/propertyCount")
    public Integer getPropertyCount(){
        return propertyService.getPropertyCount();
    }

    @PutMapping("/oneproperty/{proid}")
    public PropertyView updateProperty(@PathVariable Long proid, @RequestBody PropertyView updatedPropertyView) {
        return propertyService.updateProperty(proid, updatedPropertyView);
    }

    @DeleteMapping("oneproperty/{proid}")
    public void deleteProperty(@PathVariable Long proid) {
        propertyService.deleteProperty(proid);
    }
}
