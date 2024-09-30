package com.atividade.backend.Repository;

import com.atividade.backend.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID> {}
