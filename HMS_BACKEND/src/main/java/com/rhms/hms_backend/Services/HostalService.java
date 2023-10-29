package com.rhms.hms_backend.Services;

import com.rhms.hms_backend.Models.Hostals;
import com.rhms.hms_backend.Repositories.HostalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostalService {

    private final HostalRepo hostalRepo;

    @Autowired
    public HostalService(HostalRepo hostalRepo) {
        this.hostalRepo = hostalRepo;
    }

    public Hostals createHostal(Hostals hostals) {
        return hostalRepo.save(hostals);
    }

    public List<Hostals> getAllHostals() {
        return hostalRepo.findAll();
    }
}
