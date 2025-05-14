package com.jsp.ECommerce.respository;

import com.jsp.ECommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
