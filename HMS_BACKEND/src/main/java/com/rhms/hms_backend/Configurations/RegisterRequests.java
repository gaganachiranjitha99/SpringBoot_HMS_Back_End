package com.rhms.hms_backend.Configurations;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class RegisterRequests {
    private Long id;
    private String fname;
    private String lname;
    private String user_index;
    private String password;
    private String role;
}
