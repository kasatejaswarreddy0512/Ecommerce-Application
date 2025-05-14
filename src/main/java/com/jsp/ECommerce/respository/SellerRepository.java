package com.jsp.ECommerce.respository;

import com.jsp.ECommerce.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {
}
