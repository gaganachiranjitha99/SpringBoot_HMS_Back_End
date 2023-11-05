package com.rhms.hms_backend.Controllers;

import com.rhms.hms_backend.Models.Reports;
import com.rhms.hms_backend.Models.ResolvedComplain;
import com.rhms.hms_backend.Services.ReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;


@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private ReportService dailyReportService;

    @Autowired
    private ReportService reportService;

    @GetMapping("/dailyReport")
    public String generateDailyReport()throws JRException, FileNotFoundException{
        return dailyReportService.exportDailyReport();
    }

    @GetMapping("/monthlyReport")
    public String generateMonthlyReport()throws JRException, FileNotFoundException{
        return dailyReportService.exportMonthlyReport();
    }

    @GetMapping("/getALLReportLog")
    public List<Reports> getALLReportLog() {
        return reportService.getAllReportLog();
    }

//    @GetMapping("/getDailyReportData")
//    public List<DailyReport> getDailyReport() {
//        return dailyReportService.getDailyReportView();
//    }


}






