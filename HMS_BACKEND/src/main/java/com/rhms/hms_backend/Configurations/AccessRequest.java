package com.rhms.hms_backend.Configurations;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class AccessRequest {

    private String user_index;
    String password;
}
