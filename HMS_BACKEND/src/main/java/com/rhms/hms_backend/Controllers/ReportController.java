package com.rhms.hms_backend.Controllers;

import com.rhms.hms_backend.Services.ReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;


@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private ReportService dailyReportService;
    @GetMapping("/dailyReport")
    public String generateDailyReport()throws JRException, FileNotFoundException{
        return dailyReportService.exportDailyReport();
    }

}





