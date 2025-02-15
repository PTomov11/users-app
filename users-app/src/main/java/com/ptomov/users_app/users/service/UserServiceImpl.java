package com.ptomov.users_app.users.service;

import com.ptomov.users_app.exceptions.UserNotFoundException;
import com.ptomov.users_app.users.UserDO;
import com.ptomov.users_app.users.UserRepository;
import com.ptomov.users_app.users.dto.UserCreateDTO;
import com.ptomov.users_app.users.dto.UserUpdateDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

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
    public UserDO createUser(UserCreateDTO userCreateDTO) {
        UserDO user = new UserDO();
        user.setName(userCreateDTO.getName());
        user.setUsername(userCreateDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userCreateDTO.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public UserDO updateUser(Long id, UserUpdateDTO userUpdateDTO) {
        UserDO user = userRepository.findById(id)
            .orElseThrow(() -> new UserNotFoundException(id));

        user.setName(userUpdateDTO.getName());
        user.setUsername(userUpdateDTO.getUsername());

        if (userUpdateDTO.getPassword() != null && !userUpdateDTO.getPassword().isBlank()) {
            user.setPassword(passwordEncoder.encode(userUpdateDTO.getPassword()));
        }

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
