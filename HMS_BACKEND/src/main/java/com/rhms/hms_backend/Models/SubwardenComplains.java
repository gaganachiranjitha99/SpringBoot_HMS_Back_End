package com.rhms.hms_backend.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="subwardencomplains")
@Entity
@Builder
public class SubwardenComplains {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long c_id;

    private String user_index;

    private String c_description;

    private String c_image;

    private String c_itemcode;

    private String fname;

    private String lname;

    private String room;

    private String hostaltype;

    private String status;

    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }


}
