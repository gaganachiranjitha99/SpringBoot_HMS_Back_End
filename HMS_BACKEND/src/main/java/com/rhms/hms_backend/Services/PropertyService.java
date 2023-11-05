package com.rhms.hms_backend.Services;

import com.rhms.hms_backend.Models.Properties;
import com.rhms.hms_backend.Models.PropertyView;
import com.rhms.hms_backend.Repositories.PropertiesRepo;
import com.rhms.hms_backend.Repositories.PropertyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyService {

    private final PropertyRepo propertyRepo;
    private final PropertiesRepo propertiesRepo;

    @Autowired
    public PropertyService(PropertyRepo propertyRepo, PropertiesRepo propertiesRepo) {
        this.propertyRepo = propertyRepo;
        this.propertiesRepo = propertiesRepo;
    }

//    public Property createProperty(Property property) {
//        return propertyRepo.save(property);
//    }

    public void insertProperty(String c_itemcode, String name, String status) {
        propertiesRepo.insertProperty(c_itemcode, name, status);
    }

//    public List<Property> getAllProperty() {
//        return propertyRepo.findAll();
//    }

    @Transactional
    public List<Properties> getPropertiesView() {
        return propertiesRepo.property_view();
    }

    public Optional<PropertyView> getPropertyById(Long proid) {
        return propertyRepo.findById(proid);
    }

    public Integer getPropertyCount(){
        return Math.toIntExact(propertyRepo.count());
    }

    public PropertyView updateProperty(Long proid, PropertyView updatedPropertyView) {
        if (propertyRepo.existsById(proid)) {
            updatedPropertyView.setProid(proid);
            return propertyRepo.save(updatedPropertyView);
        } else {
            return null;
        }
    }

    public void deleteProperty(Long proid) {
        propertyRepo.deleteById(proid);
    }

}
