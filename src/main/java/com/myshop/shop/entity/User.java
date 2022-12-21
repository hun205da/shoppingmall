//package com.myshop.shop.entity;
//
//import lombok.*;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import java.util.HashSet;
//import java.util.Set;
//
//@Entity
//@Getter
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
//
//public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private String userId;
//    private String userPw;
//    private Set<UserGrade> roleSet = new HashSet<>();
//
//    public void addMemberRole(UserGrade userGrade){
//        roleSet.add(userGrade);
//    }
//}
