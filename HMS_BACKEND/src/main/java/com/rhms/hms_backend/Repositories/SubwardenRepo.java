package com.rhms.hms_backend.Repositories;

import com.rhms.hms_backend.Models.Complain;
import com.rhms.hms_backend.Models.StudentUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface SubwardenRepo extends JpaRepository<Complain,Long> {

    @Transactional
    @Procedure(procedureName="getnullstatuscomplains")
    List<Complain>getnullcomplains();


}
