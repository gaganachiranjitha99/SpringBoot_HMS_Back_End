package com.rhms.hms_backend.Controllers;

import com.rhms.hms_backend.Models.SubwardenComplains;
import com.rhms.hms_backend.Services.SubwardenService;
import com.rhms.hms_backend.Services.WardenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("api/warden")
public class WardenControl {

    @Autowired
    private WardenService wardenService;
    @GetMapping("/getComplainFromSubwarden")
    public List<SubwardenComplains> getSubwardenView() {
        return wardenService.getFromSubwardenComplains();
    }
}
