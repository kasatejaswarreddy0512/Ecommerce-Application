package com.jsp.ECommerce.service;

import com.jsp.ECommerce.config.JwtProvider;
import com.jsp.ECommerce.domain.USER_ROLE;
import com.jsp.ECommerce.entity.Cart;
import com.jsp.ECommerce.entity.User;
import com.jsp.ECommerce.response.SignupRequest;
import com.jsp.ECommerce.respository.CartRepository;
import com.jsp.ECommerce.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private JwtProvider jwtProvider;

    public String createUser(SignupRequest req){

        User user=userRepository.findByEmail(req.getEmail());
        if(user==null){
            User createdUser=new User();
            createdUser.setEmail(req.getEmail());
            createdUser.setFullName(req.getFullname());
            createdUser.setRole(USER_ROLE.ROLE_CUSTOMER);
            createdUser.setMobile("9790321456");
            createdUser.setPassword(passwordEncoder.encode(req.getOtp()));
            userRepository.save(createdUser);//user

            //Cart
            Cart cart= new Cart();
            cart.setUser(createdUser);//user
            cartRepository.save(cart);
        }

        List<GrantedAuthority> authorities=new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(USER_ROLE.ROLE_CUSTOMER.toString()));

        Authentication authentication=new UsernamePasswordAuthenticationToken(req.getEmail(),null,authorities);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return jwtProvider.generateToken(authentication);

    }
}
