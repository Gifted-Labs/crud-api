package com.systemsguy.userapi.model;

import jakarta.persistence.*;


@Entity
@Table(name = "users")

public class UserEntity {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private long id;

    @Column(name="fullName")
    private String fullName;

    @Column(name="email")
    private String email;


    public UserEntity(){

    }

    public UserEntity(long id, String fullName, String email) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
   
}
