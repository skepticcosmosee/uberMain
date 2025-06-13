package com.example.uber.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Table;



import jakarta.persistence.Id;
import jakarta.persistence.Column;


@Entity
    @Table(name = "users")
    public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;

    @Getter
    @Setter
    @Column(unique = true)
        private String email;

        private String password;

        private String role; // "DRIVER" or "PASSENGER"





    // Add Lombok annotations
    }


