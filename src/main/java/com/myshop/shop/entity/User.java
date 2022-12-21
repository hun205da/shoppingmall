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
    @Column(length = 30,nullable = false)
    private String userId;
    @Column(length = 50, nullable = false)
    private String userPw;
    @Column(length = 20, nullable = true)
    private String userName;
    @Column(length = 20, nullable = true)
    private String userPhone;
    @Column(length = 50,  nullable = true)
    private String userEmail;
    @Column(length = 20, nullable = true)
    private String userNickname;
    @Column(length = 1,  nullable = true)
    private String emailCheck;
    @Column(length = 10, nullable = true)
    private int userRole;
    @Column(length = 10,  nullable = true)
    private int userGrade;

}
