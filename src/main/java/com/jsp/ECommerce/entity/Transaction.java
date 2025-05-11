package com.jsp.ECommerce.entity;

import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User user;

    @OneToOne
    private Order order;

    @ManyToOne
    private Seller seller;

    private LocalDateTime date=LocalDateTime.now();
}
