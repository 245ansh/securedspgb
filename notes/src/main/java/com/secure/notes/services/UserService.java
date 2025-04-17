package com.secure.notes.services;

import com.secure.notes.dtos.UserDTO;
import com.secure.notes.models.Role;
import com.secure.notes.models.User;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;
public interface UserService {
    void updateUserRole(Long userId, String roleName);
    List<User> getAllUsers();
    UserDTO getUserById(Long id);
}
