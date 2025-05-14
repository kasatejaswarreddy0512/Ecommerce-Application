package com.jsp.ECommerce.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {

    private String email;
    private String fullname;
    private String otp;


}
