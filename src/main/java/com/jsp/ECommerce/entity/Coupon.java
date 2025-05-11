package com.jsp.ECommerce.entity;


import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String code;
    private double discountPercentage;

    private LocalDate start_Date;

    private LocalDate end_Date;
    private double minimumOrderValue;
    private boolean isActive=true;

    @ManyToMany(mappedBy = "usedCoupons")
    private Set<User> userByUsers=new HashSet<>();



}
