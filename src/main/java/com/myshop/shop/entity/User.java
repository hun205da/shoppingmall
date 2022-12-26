package com.myshop.shop.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class User{
    @Id
    private String userId;
    private String userPw;
    private String userName;
    private boolean fromSocial;
    @ElementCollection(fetch = FetchType.LAZY)
    private Set<UserRole> roleSet;

    public void addMemberRole(UserRole userRole){
        roleSet.add(userRole);
    }
}
