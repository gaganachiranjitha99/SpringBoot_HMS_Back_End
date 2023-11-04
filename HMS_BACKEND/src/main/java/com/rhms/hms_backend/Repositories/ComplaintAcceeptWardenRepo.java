package com.rhms.hms_backend.Repositories;

import com.rhms.hms_backend.Models.WardenComplains;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintAcceeptWardenRepo extends JpaRepository<WardenComplains,Long> {


}
