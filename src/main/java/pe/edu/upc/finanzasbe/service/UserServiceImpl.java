package pe.edu.upc.finanzasbe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.finanzasbe.repository.UserRepository;
import pe.edu.upc.finanzasbe.repository.entities.UserEntity;

import javax.persistence.EntityNotFoundException;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    public static final String COULD_NOT_FIND_ENTITY_WITH_ID = "Could not find Entity with id: %s!";

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public UserEntity getByUserId(Long id) {
        return this.userRepository.findById(id).orElse(null);
    }

    @Override
    public UserEntity getByUsername(String username) {
        return this.userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public UserEntity createUser(UserEntity user) {
        return this.userRepository.save(user);
    }

    @Override
    public UserEntity updateUser(Long id, UserEntity user) {
        UserEntity oldUser = this.userRepository.findById(id).orElse(null);

        if (oldUser == null) {
            return null;
        }

        user.setUserId(oldUser.getUserId());
        return this.userRepository.save(user);
    }

    @Override
    public void deleteUser(Long userId) {
        UserEntity oldUser = this.userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException(String.format(COULD_NOT_FIND_ENTITY_WITH_ID, userId)));

        this.userRepository.delete(oldUser);
    }
}
