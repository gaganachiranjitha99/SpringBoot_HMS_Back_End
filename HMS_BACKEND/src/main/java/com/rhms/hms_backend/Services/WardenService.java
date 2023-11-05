package com.rhms.hms_backend.Services;

import com.rhms.hms_backend.Models.WardenComplains;
import com.rhms.hms_backend.Repositories.ComplaintAcceeptWardenRepo;
import com.rhms.hms_backend.Repositories.WardenRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WardenService {

    @Autowired
    private WardenRepo wardenRepo;

    @Autowired
    private ComplaintAcceeptWardenRepo complaintAcceeptWardenRepo;


    @Transactional
    public List<WardenComplains> warden_null_complain_view () {
        return wardenRepo.warden_null_complain_view();

    }

    //UPDATE resolve Accept STATUS
    public void resolveComplain(Long c_id) {
        WardenComplains wardenComplains = complaintAcceeptWardenRepo.findById(c_id).orElseThrow(() -> new EntityNotFoundException(c_id.toString()));
        wardenComplains.setStatus("Accepted!");
        complaintAcceeptWardenRepo.save(wardenComplains);
    }
}
