package com.chandimal.chatapplication.repo;

import com.chandimal.chatapplication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface UserRepo extends JpaRepository<User,Integer> {

    @Modifying
    @Query("update User u set u.imageUrl = ?1 where u.email= ?2")
    void updateImgUrlByEmail(String imgUrl, String email);
}
