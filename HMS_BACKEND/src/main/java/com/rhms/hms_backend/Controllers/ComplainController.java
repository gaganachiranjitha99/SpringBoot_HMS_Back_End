package com.rhms.hms_backend.Controllers;


import com.rhms.hms_backend.Models.Complain;
import com.rhms.hms_backend.Services.ComplainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/{complaintId}")
    private Complain getCompalintById(@PathVariable("complaintId") Long complaintID){
        return complainService.getById(complaintID);
    }
    


}
