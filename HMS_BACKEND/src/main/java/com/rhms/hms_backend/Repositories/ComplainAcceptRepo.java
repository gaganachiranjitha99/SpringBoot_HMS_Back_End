package com.rhms.hms_backend.Repositories;

import com.rhms.hms_backend.Models.Complain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplainAcceptRepo extends JpaRepository<Complain,Long> {


}
