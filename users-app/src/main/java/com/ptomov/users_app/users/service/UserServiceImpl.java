package com.ptomov.users_app.users.service;

import com.ptomov.users_app.exceptions.UserNotFoundException;
import com.ptomov.users_app.users.UserDO;
import com.ptomov.users_app.users.UserRepository;
import com.ptomov.users_app.users.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDO getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public List<UserDO> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserDO createUser(UserDTO userDTO) {
        UserDO user = new UserDO();
        user.setName(userDTO.getName());
        return userRepository.save(user);
    }

    @Override
    public UserDO updateUser(Long id, UserDTO userDTO) {
        UserDO user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        user.setName(userDTO.getName());
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
    }
}
