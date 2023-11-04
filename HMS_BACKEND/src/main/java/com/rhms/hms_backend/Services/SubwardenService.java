package com.rhms.hms_backend.Services;


import com.rhms.hms_backend.Models.Complain;
import com.rhms.hms_backend.Models.SubwardenComplains;
import com.rhms.hms_backend.Repositories.ComplainAcceptRepo;
import com.rhms.hms_backend.Repositories.SubwardenRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SubwardenService {


    @Autowired
    private ComplainAcceptRepo complainAcceptRepo;


    public void resolveComplain(Long c_id) {
        Complain complain = complainAcceptRepo.findById(c_id).orElseThrow(() -> new EntityNotFoundException(c_id.toString()));
        complain.setStatus("Accepted!");
        complainAcceptRepo.save(complain);
    }
}
