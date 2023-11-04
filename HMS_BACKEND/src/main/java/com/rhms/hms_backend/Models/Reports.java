package com.rhms.hms_backend.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="reports")
@Entity
public class Reports {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long report_id;
    private String report_name;
    private String path;
    private Date date;
 public void setDate(Date date){
     this.date=new Date();
 }

 public String getDate(){

     SimpleDateFormat sdf=new SimpleDateFormat("M/d/yyyy");
     return sdf.format(this.date);
 }



}
