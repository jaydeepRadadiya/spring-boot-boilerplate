package com.example.demo.controller.params;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserResponse {

    private Long id;
    private String name;
    private String role;
}
