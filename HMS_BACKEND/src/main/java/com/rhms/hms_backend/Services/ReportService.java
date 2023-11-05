package com.rhms.hms_backend.Services;

import com.rhms.hms_backend.Models.DailyReport;
import com.rhms.hms_backend.Models.Reports;
import com.rhms.hms_backend.Repositories.ReportRepo;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional
public class ReportService {
    @Autowired
    private ReportRepo reportRepo;

    private final JdbcTemplate jdbcTemplate;


    //local variable to store current data.
    LocalDate currentDate=LocalDate.now();
    DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");

    String dateCreated=currentDate.format(formatter);

    public String exportDailyReport() throws FileNotFoundException, JRException{

        String reportPath="C:\\Users\\milin\\Documents\\HOSTAL_MANAGEMENT_SYSTEM\\BACK_END\\SpringBoot_HMS_Back_End\\HMS_BACKEND\\report\\Daily Reports\\";
        //retrive all the records from the daily report table table
        List<DailyReport> reportdata=jdbcTemplate.query("CALL CreateTodayComplaintView();",new DailyReportRowMapper());



        File file= ResourceUtils.getFile("classpath:dailyreport.jrxml");
        JasperReport jasperReport= JasperCompileManager.compileReport(file.getAbsolutePath());

        JRBeanCollectionDataSource source=new JRBeanCollectionDataSource(reportdata);
        Map<String,Object> parameters=new HashMap<>();
        parameters.put("Createdby","Faculty of technology");

        //saving the report file in to the database
        String sql="INSERT INTO reports(report_name,path,date)VALUES(?,?,?)";
        KeyHolder keyHolder=new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, "Daily" + dateCreated + ".pdf");
            ps.setString(2, reportPath + ".pdf");
            ps.setTimestamp(3,new Timestamp(System.currentTimeMillis()));
            return ps;
        },keyHolder);

        // print the report
        JasperPrint print= JasperFillManager.fillReport(jasperReport,parameters,source);
        JasperExportManager.exportReportToPdfFile(print,reportPath+"Complains"+System.currentTimeMillis()+".pdf");

            return  "report generated succesfully at:"+reportPath;
        }


    public String exportMonthlyReport() throws FileNotFoundException, JRException{

        String reportPath="C:\\Users\\milin\\Documents\\HOSTAL_MANAGEMENT_SYSTEM\\BACK_END\\SpringBoot_HMS_Back_End\\HMS_BACKEND\\report\\Monthly Reports\\";
        //retrive all the records from the daily report table table
        List<DailyReport> reportdata=jdbcTemplate.query("CALL CreateCurrentMonthComplaintView();",new DailyReportRowMapper());



        File file= ResourceUtils.getFile("classpath:monthlyreport.jrxml");
        JasperReport jasperReport= JasperCompileManager.compileReport(file.getAbsolutePath());

        JRBeanCollectionDataSource source=new JRBeanCollectionDataSource(reportdata);
        Map<String,Object> parameters=new HashMap<>();
        parameters.put("Createdby","Faculty of technology");

        //saving the report file in to the database
        String sql="INSERT INTO reports(report_name,path,date)VALUES(?,?,?)";
        KeyHolder keyHolder=new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, "Monthly" + dateCreated + ".pdf");
            ps.setString(2, reportPath + ".pdf");
            ps.setTimestamp(3,new Timestamp(System.currentTimeMillis()));
            return ps;
        },keyHolder);

        // print the report
        JasperPrint print= JasperFillManager.fillReport(jasperReport,parameters,source);
        JasperExportManager.exportReportToPdfFile(print,reportPath+"Complains"+System.currentTimeMillis()+".pdf");

        return  "report generated succesfully at:"+reportPath;
    }


    private static class DailyReportRowMapper implements RowMapper<DailyReport>{


            @Override
            public DailyReport mapRow(ResultSet rs, int rowNum) throws SQLException {
                DailyReport dailyReport=new DailyReport();
                dailyReport.setC_id(rs.getLong("c_id"));
                dailyReport.setUser_index(rs.getString("user_index"));
                dailyReport.setC_description(rs.getString("c_description"));
                dailyReport.setC_itemcode(rs.getString("c_itemcode"));
                dailyReport.setHostaltype(rs.getString("hostaltype"));
                dailyReport.setRoom(rs.getString("room"));
                dailyReport.setStatus(rs.getString("status"));
                dailyReport.setCreated_at(rs.getTimestamp("created_at").toLocalDateTime());


                return dailyReport;
            }





        }

    public List<Reports> getAllReportLog() {
        return reportRepo.findAll();
    }

    }
