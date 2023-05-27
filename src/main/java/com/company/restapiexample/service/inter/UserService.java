package com.company.restapiexample.service.inter;

import com.company.restapiexample.dto.UserDto;
import com.company.restapiexample.entity.User;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();

    UserDto findUserById(Integer UserId);

    User getUserById(Integer id);

    void addUser(UserDto User);

    void updateUser(UserDto User);

    void deleteUserById(Integer UserId);

}
