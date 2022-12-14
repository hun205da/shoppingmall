package com.myshop.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CsDTO {
    private long no;
    private String title;
    private String text;
    private String files;
    private String category;
    private String user_id;
    private LocalDateTime date;
    private LocalDateTime regDate, modDate;
}
