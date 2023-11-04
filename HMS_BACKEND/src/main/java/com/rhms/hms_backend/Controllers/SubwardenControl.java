package com.rhms.hms_backend.Controllers;

import com.rhms.hms_backend.Models.SubwardenComplains;
import com.rhms.hms_backend.Services.SubwardenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subwarden")
public class SubwardenControl {

    @Autowired
    private SubwardenService subwardenService;


    @PutMapping("/getresolvebysubwarden/{c_id}")
    public void resolveComplain(@PathVariable Long c_id) {
        subwardenService.resolveComplain(c_id);
    }
}
