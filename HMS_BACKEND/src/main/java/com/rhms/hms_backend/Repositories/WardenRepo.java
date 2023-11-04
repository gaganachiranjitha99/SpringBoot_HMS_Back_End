package com.rhms.hms_backend.Repositories;

import com.rhms.hms_backend.Models.SubwardenComplains;
import com.rhms.hms_backend.Models.WardenComplains;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface WardenRepo extends JpaRepository<WardenComplains,Long> {

    @Transactional
    @Procedure(procedureName="warden_null_complain_view")
    List<WardenComplains> warden_null_complain_view();


}
