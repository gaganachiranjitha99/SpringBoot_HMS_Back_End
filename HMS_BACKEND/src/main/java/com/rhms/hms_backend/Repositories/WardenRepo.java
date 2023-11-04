package com.rhms.hms_backend.Repositories;

import com.rhms.hms_backend.Models.SubwardenComplains;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface WardenRepo extends JpaRepository<SubwardenComplains,Long> {

    @Transactional
    @Procedure(procedureName="get_Complain_From_Subwarden")
    List<SubwardenComplains> get_Complain_From_Subwarden();


}