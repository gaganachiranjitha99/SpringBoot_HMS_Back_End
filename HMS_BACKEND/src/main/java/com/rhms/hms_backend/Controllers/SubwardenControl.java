package com.rhms.hms_backend.Controllers;

import com.rhms.hms_backend.Models.Complain;
import com.rhms.hms_backend.Models.StudentUsers;
import com.rhms.hms_backend.Services.SubwardenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/subwarden")
public class SubwardenControl {

    @Autowired
    private SubwardenService subwardenService;

    @GetMapping("/getAllNullComplains")
    public List<Complain> getStudentUsersView() {
        return subwardenService.getAllNullComplains();
    }
}
