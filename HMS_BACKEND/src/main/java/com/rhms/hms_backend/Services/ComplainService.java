package com.rhms.hms_backend.Services;

import com.rhms.hms_backend.Models.Complain;
import com.rhms.hms_backend.Repositories.ComplainRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.time.LocalDateTime;

@Service
public class ComplainService {

   @Autowired
   private ComplainRepo complainRepo;


    public Complain createComplain(Complain complain) {
        return complainRepo.save(complain);
    }


//    public List<Complain> getAllComplaints() {
//        return complainRepo.findAll();
//    }



}
