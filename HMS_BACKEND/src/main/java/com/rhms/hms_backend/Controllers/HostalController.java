package com.rhms.hms_backend.Controllers;

import com.rhms.hms_backend.Models.Hostals;
import com.rhms.hms_backend.Services.HostalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/hostal")
public class HostalController {

    @Autowired
    private HostalService hostalService;

    @PostMapping("/create")
    public ResponseEntity<Hostals> createHostal(@RequestBody Hostals hostals) {
        Hostals createdHostal = hostalService.createHostal(hostals);
        return new ResponseEntity<>(createdHostal, HttpStatus.CREATED);
    }

    @GetMapping("/hostals")
    public List<Hostals> getAllHostals() {
        return hostalService.getAllHostals();
    }
}
