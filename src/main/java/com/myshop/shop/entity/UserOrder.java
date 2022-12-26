package com.myshop.shop.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Cart")
@ToString(exclude = "User")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserOrder{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long orderNumber;
    @Column(length = 50 ,nullable = false)
    private String orderDate;
        @Column(length = 50 ,nullable = false)
        private String address1;
    @Column(length = 50 ,nullable = false)
    private String address2;
    @Column(length = 50 ,nullable = false)
    private String address3;
    @Column(length = 10 ,nullable = false)
    private String receiverName;
    @Column(length = 10 ,nullable = false)
    private String receiverPhone;
        @ManyToOne(fetch = FetchType.LAZY)
        private User user;


}
