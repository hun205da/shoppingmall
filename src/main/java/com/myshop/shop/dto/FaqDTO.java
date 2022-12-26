package com.myshop.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FaqDTO {
    private Long no;
    private String title;
    private String text;
    private String category;
    private LocalDateTime regDate, modDate;
}
