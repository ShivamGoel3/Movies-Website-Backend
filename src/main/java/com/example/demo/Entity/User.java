package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

@Entity
@Table(name = "_User")
public class User {


    @Id
    @Column()
    private String email;

    @Column()
    private String password;
    @Column()
    private String name;
    @Column()
    private int age;
    @Column()
    private Long mobilenumber;
}
