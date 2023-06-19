package com.company.restapiexample.service.inter;

import com.company.restapiexample.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();

    UserDto findUserById(Integer UserId);

    void addUser(UserDto User);

    void updateUser(UserDto User);

    void deleteUserById(Integer UserId);

}
