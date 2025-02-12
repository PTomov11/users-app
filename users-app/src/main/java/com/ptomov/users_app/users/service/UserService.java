package com.ptomov.users_app.users.service;

import com.ptomov.users_app.users.UserDO;
import com.ptomov.users_app.users.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDO getUserById(Long id);

    List<UserDO> getAllUsers();

    UserDO createUser(UserDTO userDTO);

    UserDO updateUser(Long id, UserDTO userDTO);

    void deleteUser(Long id);
}
