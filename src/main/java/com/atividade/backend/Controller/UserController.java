package com.atividade.backend.Controller;

import com.atividade.backend.Dto.CreateUserDto;
import com.atividade.backend.Dto.UpdateUserDto;
import com.atividade.backend.Model.UserModel;
import com.atividade.backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/")
    public ResponseEntity<UserModel> createUser(@RequestBody CreateUserDto user) {
        System.out.println(user);
       UserModel userCreated = this.userService.createUser(user);
       return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }
    @GetMapping("/")
    public ResponseEntity<List> findAll() {
        List<UserModel> users = this.userService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional> findOneUser(@PathVariable UUID id) {
        Optional<UserModel> user = this.userService.findOneUser(id);
        return  ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable UUID id) {
        Boolean user = this.userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserModel> updateUser(@PathVariable UUID id, @RequestBody UpdateUserDto updateUserDto) {
        UserModel user = this.userService.updateUser(id, updateUserDto);
        return  ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
