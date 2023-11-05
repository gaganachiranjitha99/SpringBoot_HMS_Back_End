package com.rhms.hms_backend.Repositories;


import com.rhms.hms_backend.Models.late3complains;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface late3repo extends JpaRepository<late3complains,Long> {

    @Transactional
    @Procedure(procedureName="subwarden_complain_view")
    List<late3complains> subwarden_complain_view();



}
