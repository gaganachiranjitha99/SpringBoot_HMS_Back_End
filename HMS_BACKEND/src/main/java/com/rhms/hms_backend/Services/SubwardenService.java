package com.rhms.hms_backend.Services;


import com.rhms.hms_backend.Models.StaffUsers;
import com.rhms.hms_backend.Models.SubwardenComplains;
import com.rhms.hms_backend.Repositories.SubwardenRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.rhms.hms_backend.Controllers.SubwardenControl;
import com.rhms.hms_backend.Models.Complain;
import com.rhms.hms_backend.Models.StudentUsers;
import com.rhms.hms_backend.Repositories.SubwardenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

import java.util.List;

@Service
public class SubwardenService {


    SubwardenRepo subwardenRepo;
    @Transactional
    public List<SubwardenComplains>getFromSubwardenComplains() {
        return subwardenRepo.get_Complain_From_Subwarden();

    @Autowired
    private SubwardenRepo subwardenRepo;

    @Transactional
    public List<Complain> getAllNullComplains() {
        return subwardenRepo.getnullcomplains();

    }
}
