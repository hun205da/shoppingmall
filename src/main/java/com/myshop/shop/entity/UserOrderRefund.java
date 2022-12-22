package com.myshop.shop.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Cart")
@ToString(exclude = "UserOrderDetail")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserOrderRefund {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long refundNumber;
    @Column(length = 50, nullable = false)
    private String refundReason;
    @Column(length = 50, nullable = false)
    private String refundImg;
    @Column(length = 50, nullable = true)
    private String userEmail;
    @ManyToOne(fetch = FetchType.LAZY)
    private UserOrderDetail userOrderDetail;

}

