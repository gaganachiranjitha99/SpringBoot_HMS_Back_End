package com.rhms.hms_backend.Controllers;

import com.rhms.hms_backend.Models.DeanComplains;
import com.rhms.hms_backend.Models.WardenComplains;
import com.rhms.hms_backend.Services.DeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dean")
public class DeanControl {

    @Autowired
    private DeanService deanService;


    @GetMapping("/getAllNullComplainstoDean")
    public List<DeanComplains> getWardenView() {
        return deanService.warden_null_complain_view();
    }

    @PutMapping("/getresolvebydean/{c_id}")
    public void resolveComplain(@PathVariable Long c_id) {
        deanService.resolveComplain(c_id);
    }
}
