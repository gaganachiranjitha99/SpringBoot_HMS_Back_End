package com.rhms.hms_backend.Services;


import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;

@Service
public class ReportSheduleService {

    @Autowired
    private ReportService reportService;

    @Scheduled(cron = "0 21 18 * * ?") // Daily at 00:00:00
    public void generateDailyReport() {
        try {
            reportService.exportDailyReport();
        } catch (FileNotFoundException | JRException e) {

        }
    }

    @Scheduled(cron = "0 21 18 * * ?") // Monthly at the first day of the month        cron = "0 0 0 1 * ?"
    public void generateMonthlyReport() {
        try {
            reportService.exportMonthlyReport();
        } catch (FileNotFoundException | JRException e) {

        }
    }


}
