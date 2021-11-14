package pe.edu.upc.finanzasbe.service;

import pe.edu.upc.finanzasbe.repository.entities.UserEntity;

import java.util.List;

public interface UserService {

    List<UserEntity> getAllUsers();

    UserEntity getByUserId(Long id);

    UserEntity getByUsername(String username);

    UserEntity createUser(UserEntity user);

    UserEntity updateUser(Long id, UserEntity user);

    void deleteUser(Long userId);
}
