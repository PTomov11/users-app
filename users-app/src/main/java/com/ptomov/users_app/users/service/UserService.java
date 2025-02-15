package com.ptomov.users_app.users.service;

import com.ptomov.users_app.users.UserDO;
import com.ptomov.users_app.users.dto.UserCreateDTO;
import com.ptomov.users_app.users.dto.UserUpdateDTO;

import java.util.List;

public interface UserService {

    UserDO getUserById(Long id);

    List<UserDO> getAllUsers();

    UserDO createUser(UserCreateDTO userCreateDTO);

    UserDO updateUser(Long id, UserUpdateDTO userUpdateDTO);

    void deleteUser(Long id);
}
