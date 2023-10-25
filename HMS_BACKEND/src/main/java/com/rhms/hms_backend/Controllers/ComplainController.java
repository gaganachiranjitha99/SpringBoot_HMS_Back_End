package com.rhms.hms_backend.Controllers;


import com.rhms.hms_backend.Models.Complain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/user/complaints")
public class ComplainController {


    @Autowired
    private ComplaintService complaintService;

    @PostMapping("/createComplaint")
    public ResponseEntity<Complain> createComplaint(@RequestBody Complain complain) {
        Complain createdComplaint = complaintService.createComplaint(complain);
        return new ResponseEntity<>(createdComplaint, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Complain>> getAllComplaints() {
        List<Complain> complaints = complaintService.getAllComplaints();
        return new ResponseEntity<>(complaints, HttpStatus.OK);
    }
}
