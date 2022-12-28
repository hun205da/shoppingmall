package com.myshop.shop.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "NonuserOrderRefund")
@ToString(exclude = "nonuserOrderDetail")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NonuserOrderRefund {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long refundNumber;

    @Column(length = 50,nullable = false)
    private String refundReason;
    @Column(length = 50 ,nullable = false)
    private String refundImg;
    @Column(length = 10 ,nullable = false)
    private String refundEmail;
    @ManyToOne(fetch = FetchType.LAZY)
    private NonuserOrderDetail nonuserOrderDetail;
}
