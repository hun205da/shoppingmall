package com.myshop.shop.security.service;

import com.myshop.shop.entity.User;
import com.myshop.shop.repository.UserRepository;
import com.myshop.shop.security.dto.ShopAuthUserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class ShopUserDetailsService  implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("ClubUserDetailsService loadUserByUsername " + username);


        Optional<User> result = userRepository.findByEmail(username, false);

        if(result.isEmpty()){
            throw new UsernameNotFoundException("Check User Email or from Social ");
        }

        User user = result.get();

        log.info("-----------------------------");
        log.info(user);

        ShopAuthUserDTO clubAuthMember = new ShopAuthUserDTO(
                user.getUserId(),
                user.getUserPw(),
                user.isFromSocial(),
                user.getRoleSet().stream()
                        .map(role -> new SimpleGrantedAuthority("ROLE_"+role.name()))
                        .collect(Collectors.toSet())
        );

        clubAuthMember.setUsername(user.getUserName());
        clubAuthMember.setFromSocial(user.isFromSocial());

        return clubAuthMember;
    }
}
