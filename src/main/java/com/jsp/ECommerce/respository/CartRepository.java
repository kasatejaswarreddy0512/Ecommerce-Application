package com.jsp.ECommerce.respository;

import com.jsp.ECommerce.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
