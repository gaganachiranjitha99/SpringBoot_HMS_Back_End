package com.rhms.hms_backend.Repositories;


import com.rhms.hms_backend.Models.DailyReport;
import com.rhms.hms_backend.Models.Properties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface DailyReportRepo extends JpaRepository<DailyReport,Long> {


    @Transactional
    @Procedure(procedureName = "CreateTodayComplaintView")
    List<DailyReport> CreateTodayComplaintView();

}
