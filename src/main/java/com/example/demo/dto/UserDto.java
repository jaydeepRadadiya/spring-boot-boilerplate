package com.example.demo.dto;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class UserDto implements Serializable {
    private Long id;
    private String name;
    private String role;
}
