package com.rhms.hms_backend.Services;

import com.rhms.hms_backend.Models.Hostals;
import com.rhms.hms_backend.Models.Property;
import com.rhms.hms_backend.Repositories.PropertyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyService {

    private final PropertyRepo propertyRepo;

    @Autowired
    public PropertyService(PropertyRepo propertyRepo) {
        this.propertyRepo = propertyRepo;
    }

    public Property createProperty(Property property) {
        return propertyRepo.save(property);
    }

    public List<Property> getAllProperty() {
        return propertyRepo.findAll();
    }

    public Optional<Property> getPropertyById(Long proid) {
        return propertyRepo.findById(proid);
    }

    public Integer getPropertyCount(){
        return Math.toIntExact(propertyRepo.count());
    }

    public Property updateProperty(Long proid, Property updatedProperty) {
        if (propertyRepo.existsById(proid)) {
            updatedProperty.setProid(proid);
            return propertyRepo.save(updatedProperty);
        } else {
            return null;
        }
    }

    public void deleteProperty(Long proid) {
        propertyRepo.deleteById(proid);
    }

}
