package com.myshop.shop.security.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Log4j2
@Getter
@Setter
@ToString
public class ShopAuthUserDTO extends User {

    private String userId;

    private String username;

    private boolean fromSocial;

    public ShopAuthUserDTO(String username, String password, boolean fromSocial,
                           Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.userId = username;
        this.fromSocial = fromSocial;
    }
}
