package com.rhms.hms_backend.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "hostals")

public class Hostals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hostalID;

    @Column(unique = true)
    private String hostaltype;

    @Column(nullable = false)
    private String room;

    @Column(nullable = false)
    private String wardern_name;

    @Column(nullable = false)
    private int no_of_sub_wardens;

}
