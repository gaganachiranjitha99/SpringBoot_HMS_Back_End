package com.rhms.hms_backend.Services;

import com.rhms.hms_backend.Models.Complain;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.*;

public class ComplainService {

    private final ComplaintRepository complaintRepository;

    @Autowired
    public ComplaintService(ComplaintRepository complaintRepository) {
        this.complaintRepository = complaintRepository;
    }

    public Complain createComplaint(Complain complain) {
        // You can perform any necessary business logic here
        // For example, additional validation or processing before saving the complaint
        return complaintRepository.save(complain);
    }

    public List<Complain> getAllComplaints() {
        return complaintRepository.findAll();
    }



}
