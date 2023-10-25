package com.rhms.hms_backend.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="complain")
@Entity
@Builder
public class Complain {

    @Id
    @GeneratedValue
    private Long c_id;

    @Column(name = "student_id")
    private String studentId;

    @Column(name = "c_description")
    private String c_description;

    @Column(name = "c_image")
    private String c_image;

    @Column(name = "c_itemcode")
    private String c_itemcode;

    @Column(name = "f_name")
    private String f_name;

    @Column(name = "l_name")
    private String l_name;

    @Column(name = "room_no")
    private String roomNo;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)

    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }



}
