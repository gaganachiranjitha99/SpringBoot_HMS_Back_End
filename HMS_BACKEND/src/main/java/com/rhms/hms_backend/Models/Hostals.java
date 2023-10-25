package com.rhms.hms_backend.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Hostals")

public class Hostals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String hostalID;

    @Column(nullable = false)
    private String rooms;

    @Column(nullable = false)
    private String wardernName;

    @Column(nullable = false)
    private int noOfSubWardens;

}
