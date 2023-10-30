package com.rhms.hms_backend.Services;

import com.rhms.hms_backend.Models.Complain;
import com.rhms.hms_backend.Repositories.ComplainRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ComplainService {

   @Autowired
   private ComplainRepo complainRepo;


    public Complain createComplain(Complain complain) {
        return complainRepo.save(complain);
    }


    public Complain getById(Long id){
        Optional<Complain> optionalComplaint = complainRepo.findById(id);

        if (optionalComplaint.isPresent()) {
            return optionalComplaint.get();
        } else {
            throw new EntityNotFoundException("Complain with ID " + id + " not found");
        }
    }


    public List<Complain> getAllComplains(){
        List<Complain> complains = new ArrayList<>();
        complainRepo.findAll().forEach(complain -> complains.add(complain));
        return complains;
    }

    public void delete(Long id) {
        complainRepo.deleteById(id);
    }



}
