package com.rhms.hms_backend.Controllers;

import com.rhms.hms_backend.Models.StaffUsers;
import com.rhms.hms_backend.Models.SubwardenComplains;
import com.rhms.hms_backend.Services.SubwardenService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("api/warden")
public class SubwardenController{

    SubwardenService subwardenService;
    @GetMapping("/getComplainFromSubwarden")
    public List<SubwardenComplains> getStaffUsersView() {
        return subwardenService.getFromSubwardenComplains();
    }
}
