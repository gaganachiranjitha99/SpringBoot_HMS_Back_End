package com.rhms.hms_backend.Controllers;


import com.rhms.hms_backend.Models.Complain;
import com.rhms.hms_backend.Services.ComplainService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/user/complain")
public class ComplainController {

    @Autowired
    private ComplainService complainService;

    @PostMapping("/create")
    public ResponseEntity<Complain> createComplain(@RequestBody Complain complain) {
        Complain createdComplain = complainService.createComplain(complain);
        return new ResponseEntity<>(createdComplain, HttpStatus.CREATED);
    }

    @PutMapping("/updateComplain/{complainId}")
    public Long updateComplain(@PathVariable("complainId") Long complainId, @RequestBody Complain updatedComplain) {
        Complain existingComplaint = complainService.getById(complainId);

        if (existingComplaint != null) {
            updatedComplain.setId(complainId);
            complainService.Save(updatedComplain);
            return updatedComplain.getId();
        } else {
            throw new EntityNotFoundException("Complaint with ID " + complainId + " not found");
        }
    }


    @GetMapping("/getAllComplains")
    private List<Complain> getAllComplains(){
        return complainService.getAllComplains();
    }


    @GetMapping("/getCompalintById/{complaintId}")
    private Complain getCompalintById(@PathVariable("complainId") Long complaintID){
        return complainService.getById(complaintID);
    }

    @DeleteMapping("/delete/{complainId}")
    private void DeleteComplain(@PathVariable("complainId") Long id){
        complainService.delete(id);
    }
}



    



