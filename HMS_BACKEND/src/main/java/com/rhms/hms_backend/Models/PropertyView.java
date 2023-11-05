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
@Table(name = "property")
public class PropertyView {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long proid;

    @Column(unique = true)
    private String c_itemcode;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String status;
}
