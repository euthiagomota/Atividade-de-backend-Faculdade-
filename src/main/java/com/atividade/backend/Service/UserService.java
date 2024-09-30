package com.atividade.backend.Service;

import com.atividade.backend.Dto.CreateUserDto;
import com.atividade.backend.Dto.UpdateUserDto;
import com.atividade.backend.Model.UserModel;
import com.atividade.backend.Repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public UserModel createUser(CreateUserDto user) {
        UserModel newUser = new UserModel();
        BeanUtils.copyProperties(user, newUser);
        UserModel userCreated = userRepository.save(newUser);
        System.out.println(newUser);
        return userCreated;
    }

    public List<UserModel> findAll() {
        List<UserModel> users = this.userRepository.findAll();
        return users;
    }

    public Optional<UserModel> findOneUser(UUID id) {
        Optional<UserModel> user = this.userRepository.findById(id);
        return user;
    }

    public Boolean deleteUser(UUID id) {
       UserModel user = this.userRepository.findById(id).orElse(null);
       this.userRepository.delete(user);
       return true;
    }

    public UserModel updateUser(UUID id, UpdateUserDto updateUserDto) {
        UserModel userToUpdate = this.userRepository.findById(id).orElse(null);
        BeanUtils.copyProperties(updateUserDto, userToUpdate, "id");
        UserModel userUpdated = this.userRepository.save(userToUpdate);
        return userUpdated;
    }
}
