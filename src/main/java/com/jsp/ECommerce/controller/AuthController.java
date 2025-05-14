package com.jsp.ECommerce.controller;

import com.jsp.ECommerce.domain.USER_ROLE;
import com.jsp.ECommerce.entity.User;
import com.jsp.ECommerce.response.AuthResponse;
import com.jsp.ECommerce.response.SignupRequest;
import com.jsp.ECommerce.respository.UserRepository;
import com.jsp.ECommerce.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> createUserHandler(@RequestBody SignupRequest request){
        String jwt=authService.createUser(request);
        AuthResponse authResponse=new AuthResponse();
        authResponse.setJwt(jwt);
        authResponse.setMessage("Success");
        authResponse.setRole(USER_ROLE.ROLE_CUSTOMER);

        return ResponseEntity.ok(authResponse);
    }
}
