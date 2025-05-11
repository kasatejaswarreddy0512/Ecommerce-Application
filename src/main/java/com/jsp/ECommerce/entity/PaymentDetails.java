package com.jsp.ECommerce.entity;


import com.jsp.ECommerce.domain.PaymentStatus;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDetails {
    private String paymentId;
    private String razorPaymentLinkId;
    private String razorPaymentLinkReferenceId;
    private String razorPaymentLinkStatus;
    private String razorPaymentId;
    private PaymentStatus status;
}
