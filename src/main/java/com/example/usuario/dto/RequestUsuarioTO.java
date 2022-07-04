package com.example.usuario.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RequestUsuarioTO {

    private String name;
    private String lastName;
    private Long age;
    private String gender;
    private String email; 
    
}
