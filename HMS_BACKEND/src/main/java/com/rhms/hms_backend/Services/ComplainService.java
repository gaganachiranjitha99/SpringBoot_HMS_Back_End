package com.rhms.hms_backend.Services;

import com.rhms.hms_backend.Models.Complain;
import com.rhms.hms_backend.Repositories.ComplainRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.*;

public class ComplainService {


    private final ComplainRepo complainRepo;

    @Autowired
    public ComplainService(ComplainRepo complainRepo) {
        this.complainRepo = complainRepo;
    }

    public Complain createComplaint(Complain complain) {

        return complainRepo.save(complain);
    }





}
