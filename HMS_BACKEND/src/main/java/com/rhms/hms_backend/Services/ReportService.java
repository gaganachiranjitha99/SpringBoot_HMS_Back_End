package com.rhms.hms_backend.Services;

import com.rhms.hms_backend.Models.Complain;
import com.rhms.hms_backend.Repositories.ComplainRepo;
import com.rhms.hms_backend.Repositories.ReportRepo;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ReportService {
    @Autowired
    private ReportRepo dailyReportRepo;

    private final JdbcTemplate jdbcTemplate;
    private final ComplainRepo complainRepo;

    //local variable to store current data.
    LocalDate currentDate=LocalDate.now();
    DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");

    String dateCreated=currentDate.format(formatter);

    public String exportDailyReport() throws FileNotFoundException, JRException{

        String reportPath="C:\\Users\\msi\\Documents\\GitHub\\SpringBoot_HMS_Back_End\\HMS_BACKEND\\report";
        //retrive all the records from the complain table
        List<Complain> complains=complainRepo.findAll();

        File file= ResourceUtils.getFile("classpath:dailyreport.jrxml");
        JasperReport jasperReport= JasperCompileManager.compileReport(file.getAbsolutePath());

        JRBeanCollectionDataSource source=new JRBeanCollectionDataSource(complains);
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
    }
