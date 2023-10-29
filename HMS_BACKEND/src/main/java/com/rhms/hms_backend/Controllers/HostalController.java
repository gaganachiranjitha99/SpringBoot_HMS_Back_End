package com.rhms.hms_backend.Controllers;

import com.rhms.hms_backend.Models.Hostals;
import com.rhms.hms_backend.Services.HostalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/hostals/{hostalID}")
    public Optional<Hostals> getHostalById(@PathVariable Long hostalID) {
        return hostalService.getHostalById(hostalID);
    }

    @PutMapping("/hostals/{hostalID}")
    public Hostals updateHostal(@PathVariable Long hostalID, @RequestBody Hostals updatedHostal) {
        return hostalService.updateHostal(hostalID, updatedHostal);
    }

    @DeleteMapping("hostals/{hostalID}")
    public void deleteHostal(@PathVariable Long hostalID) {
        hostalService.deleteHostal(hostalID);
    }

}
