package com.example.demo.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="User", schema="db_example")
@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private @Id
    @GeneratedValue
    Long id;

    @Column
    private String name;
    @Column
    private String role;

    public User(String name, String role) {
        this.name = name;
        this.role = role;
    }

}