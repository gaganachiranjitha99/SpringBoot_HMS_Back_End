package com.rhms.hms_backend.Repositories;

import com.rhms.hms_backend.Models.Reports;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ReportRepo extends JpaRepository<Reports,Long> {


    List<Reports>findAll();
}




