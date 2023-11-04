package com.rhms.hms_backend.Repositories;

import com.rhms.hms_backend.Models.DeanComplains;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplainAcceptedDeanRepo extends JpaRepository<DeanComplains,Long> {

}
