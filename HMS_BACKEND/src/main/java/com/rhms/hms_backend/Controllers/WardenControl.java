package com.rhms.hms_backend.Controllers;

import com.rhms.hms_backend.Models.WardenComplains;
import com.rhms.hms_backend.Services.WardenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/warden")
public class WardenControl {

    @Autowired
    private WardenService wardenService;
    @GetMapping("/getAllComplainsfromWarden")
    public List<WardenComplains> getWardenView() {
        return wardenService.warden_null_complain_view();
    }

    @PutMapping("/getresolvebywarden/{c_id}")
    public void resolveComplain(@PathVariable Long c_id) {
        wardenService.resolveComplain(c_id);
    }
}
