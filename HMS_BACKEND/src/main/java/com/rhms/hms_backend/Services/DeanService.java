package com.rhms.hms_backend.Services;

import com.rhms.hms_backend.Models.DeanComplains;
import com.rhms.hms_backend.Models.WardenComplains;
import com.rhms.hms_backend.Repositories.ComplainAcceptedDeanRepo;
import com.rhms.hms_backend.Repositories.DeanRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DeanService {

    @Autowired
    private DeanRepo deanRepo;

    @Autowired
    private ComplainAcceptedDeanRepo complainAcceptedDeanRepo;

    @Transactional
    public List<DeanComplains> warden_null_complain_view() {
        return deanRepo.dean_null_complain_view();

    }

    public void resolveComplain(Long c_id) {
        DeanComplains deanComplains = complainAcceptedDeanRepo.findById(c_id).orElseThrow(() -> new EntityNotFoundException(c_id.toString()));
        deanComplains.setStatus("Accepted!");
        complainAcceptedDeanRepo.save(deanComplains);
    }
}
