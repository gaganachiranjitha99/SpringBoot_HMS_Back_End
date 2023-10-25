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
@RequestMapping("/api/user/complains")
public class ComplainController {


    @Autowired
    private ComplainService complainService;

    @PostMapping("/createComplain")
    public ResponseEntity<Complain> createComplaint(@RequestBody Complain complain) {
        Complain createdComplaint = complainService.createComplaint(complain);
        return new ResponseEntity<>(createdComplaint, HttpStatus.CREATED);
    }


}
