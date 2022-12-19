package com.myshop.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {
    private String user_id;
    private String user_pw;
    private String user_name;
    private String user_phone;
    private String user_email;
    private String user_nickname;
    private String user_profile;
    private String email_check;
    private int user_role;
    private int user_grade;
    private LocalDateTime user_insertdate;
}
