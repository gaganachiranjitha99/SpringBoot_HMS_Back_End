package com.rhms.hms_backend.Repositories;


import com.rhms.hms_backend.Models.StaffUsers;
import com.rhms.hms_backend.Models.SubwardenComplains;

import com.rhms.hms_backend.Models.Complain;
import com.rhms.hms_backend.Models.StudentUsers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubwardenRepo extends JpaRepository<SubwardenComplains,Long> {

    @Transactional
    @Procedure(procedureName="subwarden_complain_view")
    List<SubwardenComplains> subwarden_complain_view();



}
