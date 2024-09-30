package com.atividade.backend.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity(name = "users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    @Column
    String name;
    @Column
    String cpf;
    @Column
    int age;

}
