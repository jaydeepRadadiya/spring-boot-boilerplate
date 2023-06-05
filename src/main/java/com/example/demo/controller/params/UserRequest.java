package com.example.demo.controller.params;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserRequest{

    @NotEmpty(message = "{registration_name_not_empty}")
    private String name;

    @NotEmpty(message = "{registration_role_not_empty}")
    private String role;
}
