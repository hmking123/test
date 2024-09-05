package com.example.project_management_app.repository;

import com.example.project_management_app.model.User;
import com.example.project_management_app.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    // Ajoutez une méthode pour obtenir les utilisateurs par rôle
    List<User> findByRole(Role role);
}
