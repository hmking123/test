package com.example.project_management_app.service;

import com.example.project_management_app.model.User;
import com.example.project_management_app.model.Role;
import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(User user);

    User updateUser(Long id, User user);

    Optional<User> getUserById(Long id);

    Optional<User> getUserByUsername(String username);

    Optional<User> getUserByEmail(String email);

    // Nouvelle méthode pour obtenir les utilisateurs par rôle
    List<User> getUsersByRole(Role role);

    List<User> getAllUsers();

    void deleteUser(Long id);
}
