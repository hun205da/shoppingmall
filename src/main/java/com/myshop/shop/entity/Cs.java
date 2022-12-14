package com.myshop.shop.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Cs extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 1500, nullable = false)
    private String text;

    @Column(length = 100, nullable = true)
    private String files;

    @Column(length = 100, nullable = true)
    private String category;

    @Column(length = 100, nullable = false)
    private String user_id;

    @Column(length = 100, nullable = true)
    private LocalDateTime date;

    @Column(length = 100, nullable = true)
    private String reply;

    public void changeTitle(String title){
        this.title = title;
    }

    public void changeText(String text){
        this.text = text;
    }
}
