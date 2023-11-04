package com.rhms.hms_backend.Services;

import com.rhms.hms_backend.Models.SubwardenComplains;
import com.rhms.hms_backend.Repositories.SubwardenRepo;
import com.rhms.hms_backend.Repositories.WardenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WardenService {

    @Autowired
    private WardenRepo wardenRepo;

    @Transactional
    public List<SubwardenComplains> getFromSubwardenComplains () {
        return wardenRepo.get_Complain_From_Subwarden();

    }
}
