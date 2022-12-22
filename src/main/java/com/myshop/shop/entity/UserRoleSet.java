package com.myshop.shop.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "UserRoleSet")
@ToString(exclude = "User")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleSet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long roleSet;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
