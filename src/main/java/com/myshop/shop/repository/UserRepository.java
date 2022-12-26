package com.myshop.shop.repository;

import com.myshop.shop.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    @EntityGraph(attributePaths = {"roleSet"}, type = EntityGraph.EntityGraphType.LOAD)
    @Query("select m from User m where m.fromSocial = :social and m.userId =:userId")
    Optional<User> findByEmail(String userId, boolean social);
}

