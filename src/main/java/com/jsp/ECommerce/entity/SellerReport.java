package com.jsp.ECommerce.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SellerReport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Seller seller;

    private Long totalEarning=0L;
    private Long totalSales=0L;
    private Long totalRefunds=0L;
    private Long totalTax=0L;
    private Long netEarnings=0L;
    private Integer totalOrders=0;
    private Integer cancelOrders=0;
    private Integer totalTransactions=0;

}
