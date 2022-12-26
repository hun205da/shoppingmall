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
    private String userId;
    private String userPw;
    private String userName;
    private String userPhone;
    private String userEmail;
    private int emailCheck;
    private LocalDateTime userInsertdate;






}
