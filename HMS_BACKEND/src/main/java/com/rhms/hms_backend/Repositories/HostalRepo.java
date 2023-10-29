package com.rhms.hms_backend.Repositories;

import com.rhms.hms_backend.Models.Hostals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HostalRepo extends JpaRepository<Hostals, Long> {
}
