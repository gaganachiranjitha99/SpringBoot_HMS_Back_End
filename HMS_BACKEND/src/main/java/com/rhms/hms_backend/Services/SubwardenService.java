package com.rhms.hms_backend.Services;

import com.rhms.hms_backend.Models.StaffUsers;
import com.rhms.hms_backend.Models.SubwardenComplains;
import com.rhms.hms_backend.Repositories.SubwardenRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SubwardenService {

    SubwardenRepo subwardenRepo;
    @Transactional
    public List<SubwardenComplains>getFromSubwardenComplains() {
        return subwardenRepo.get_Complain_From_Subwarden();
    }
}
