package com.chandimal.chatapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.persistence.*;

@Entity
@Table(name="user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "username",length = 100,nullable = false)
    private String username;

    @Column(name = "email",unique = true)
    private String email;

    @Column(name = "phone",unique = true)
    private String phone;

    @Column(name = "password")
    @Setter
    private String password;

    @Column(name = "image_url")
    private String imageUrl;


    public void setPassword(String password){

        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
    }



}
