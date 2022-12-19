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
    private String user_id;
    @Column(length = 50, nullable = true)
    private String user_pw;
    @Column(length = 20, nullable = true)
    private String user_name;
    @Column(length = 20, nullable = true)
    private String user_phone;
    @Column(length = 50,  nullable = true)
    private String user_email;
    @Column(length = 20, nullable = true)
    private String user_nickname;
    @Column(length = 1,  nullable = true)
    private String email_check;
    @Column(length = 10, nullable = true)
    private int user_role;
    @Column(length = 10,  nullable = true)
    private int user_grade;

}
