package com.jsp.ECommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jsp.ECommerce.domain.USER_ROLE;
import jakarta.persistence.*;
import lombok.*;


import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private String email;
    private String mobile;

    private String fullName;

    private USER_ROLE role=USER_ROLE.ROLE_CUSTOMER;

    @OneToMany
    private Set<Address> address=new HashSet<>();

    @ManyToMany
    @JsonIgnore
    private Set<Coupon> usedCoupons=new HashSet<>();


}
