package com.atividade.backend.Dto;

import lombok.Data;

@Data
public class UpdateUserDto {
    String name;
    String cpf;
    int age;
}
