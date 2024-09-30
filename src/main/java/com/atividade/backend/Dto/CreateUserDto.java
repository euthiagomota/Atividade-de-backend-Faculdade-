package com.atividade.backend.Dto;

import lombok.Data;

@Data
public class CreateUserDto {

    String name;
    String cpf;
    int age;
}
