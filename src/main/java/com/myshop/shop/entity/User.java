package com.myshop.shop.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "User")
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity{
    @Id
    @Column(length = 30,nullable = true)
    private String userId;
    @Column(length = 50, nullable = true)
    private String userPw;
    @Column(length = 20, nullable = false)
    private String userName;
    @Column(length = 20, nullable = false)
    private String userPhone;
    @Column(length = 50,  nullable = false)
    private String userEmail;
    @Column(nullable = false)
    private int emailCheck;
}
