package com.jsp.ECommerce.service;

import com.jsp.ECommerce.domain.USER_ROLE;
import com.jsp.ECommerce.entity.User;
import com.jsp.ECommerce.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    private static final String SELLER_PREFIX="seller_";

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(username.startsWith(SELLER_PREFIX)){

        }else{
            User user=userRepository.findByEmail(username);
            if(user!=null){
                return buildUserDetails(user.getEmail(),user.getPassword(),user.getRole());
            }
        }
        throw new UsernameNotFoundException("User and Seller Not Found With Email - "+username);
    }

    private UserDetails buildUserDetails(String email, String password, USER_ROLE role) {
        if(role==null) role=USER_ROLE.ROLE_CUSTOMER;

        List<GrantedAuthority> authorities=new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE"+role));
        return new org.springframework.security.core.userdetails.User(email,password,authorities);
    }
}
