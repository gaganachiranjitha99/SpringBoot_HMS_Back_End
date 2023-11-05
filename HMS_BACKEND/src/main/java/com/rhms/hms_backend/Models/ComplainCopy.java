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
@Table(name="complaincopy")
@Entity
@Builder
public class ComplainCopy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long c_id;

    @Column(nullable = false)
    private String user_index;

    @Column(nullable = false)
    private String c_description;

    @Column(nullable = false)
    private String c_image;

    @Column(nullable = false)
    private String c_itemcode;

    @Column(nullable = false)
    private String fname;

    @Column(nullable = false)
    private String lname;

    @Column(nullable = false)
    private String room;

    @Column(nullable = false)
    private String hostaltype;


    @Column(nullable = true)
    private String status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

}
