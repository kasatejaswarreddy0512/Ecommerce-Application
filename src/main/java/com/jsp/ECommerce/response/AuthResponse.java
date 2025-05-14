package com.jsp.ECommerce.response;

import com.jsp.ECommerce.domain.USER_ROLE;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.bridge.IMessage;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {

    private String jwt;
    private String message;
    private USER_ROLE role;
}
