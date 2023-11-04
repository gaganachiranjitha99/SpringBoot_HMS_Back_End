package com.rhms.hms_backend.Controllers;


import com.rhms.hms_backend.Models.Complain;
import com.rhms.hms_backend.Services.ComplainService;
import com.rhms.hms_backend.Services.QRCodeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("api/user/complain")
public class ComplainController {

    @Autowired
    private ComplainService complainService;

    @Autowired
    private QRCodeService qrCodeService;

//    @PostMapping("/create")
//    public ResponseEntity<Complain> createComplain(@RequestBody Complain complain) {
//        Complain createdComplain = complainService.createComplain(complain);
//        return new ResponseEntity<>(createdComplain, HttpStatus.CREATED);
//    }

    @PostMapping("/create")
    public ResponseEntity<Complain> createComplain(
            @RequestParam("c_itemcode") MultipartFile cItemCode,
            @RequestParam("c_description") String cDescription,
            @RequestParam("c_image") String cImage,
            @RequestParam("fname") String fname,
            @RequestParam("lname") String lname,
            @RequestParam("room") String room,
            @RequestParam("user_index") String userIndex,
            @RequestParam("hostaltype") String hostaltype
    ) {
        try {
            // 1. Save the QR code image and get QR code data
            String qrCodeData = qrCodeService.saveQRCode(cItemCode);

            // 2. Create a Complain object and set the details
            Complain complain = new Complain();
            complain.setC_itemcode(qrCodeData);
            complain.setC_description(cDescription);
            complain.setFname(fname);
            complain.setC_image(cImage);
            complain.setUser_index(userIndex);
            complain.setLname(lname);
            complain.setRoom(room);
            complain.setHostaltype(hostaltype);

            // 3. Save the Complain object to the database
            Complain createdComplain = complainService.createComplain(complain);

            return new ResponseEntity<>(createdComplain, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }





    @PutMapping("/updateComplain/{complainId}")
    public Long updateComplain(@PathVariable("complainId") Long complainId, @RequestBody Complain updatedComplain) {
        Complain existingComplaint = complainService.getById(complainId);

        if (existingComplaint != null) {
            updatedComplain.setC_id(complainId);
            complainService.Save(updatedComplain);
            return updatedComplain.getC_id();
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


    @GetMapping("/getComplainsByCurrentUser")
    public ResponseEntity<List<Complain>> getComplaintsByCurrentUser() {
        // Get the currently authenticated user's ID
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String user_index = authentication.getName();

        List<Complain> complains = complainService.getComplainsByUserId(user_index);
        return new ResponseEntity<>(complains, HttpStatus.OK);
    }





}



    



