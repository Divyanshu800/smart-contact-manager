package com.scm.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "user")
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

//Ye User ka schema hai(model)
public class User {

    @Id
    private String userId;

    @Column(name = "user_name", nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    // Changed to TEXT to resolve row size issue
    @Column(length = 1000)
    private String about;

    // Changed to TEXT to resolve row size issue
    @Column(length = 1000)
    private String profilePic;
    
    private String phoneNumber;

    private boolean enabled;
    private boolean emailVerified;
    private boolean phoneVerified;


    @Enumerated(value = EnumType.STRING) //taaki enum waala data table min store ho jaaye or woh string format mein save ho
    private Providers provider = Providers.SELF;
    private String providerUserId;

    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL , fetch = FetchType.LAZY , orphanRemoval = true)
    private List<Contact> contacts = new ArrayList<>();


}
