package com.company.restapiexample.service.impl;

import com.company.restapiexample.dto.UserDto;
import com.company.restapiexample.entity.User;
import com.company.restapiexample.exception.UserNotFoundException;
import com.company.restapiexample.mapper.UserMapper;
import com.company.restapiexample.repo.UserRepository;
import com.company.restapiexample.service.inter.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(userMapper::toDto).toList();
    }

    @Override
    public UserDto findUserById(Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found with id: " + userId));
        return userMapper.toDto(user);
    }

    @Override
    public void addUser(UserDto user) {
        userRepository.save(userMapper.toEntity(user));
    }

    @Override
    public void updateUser(UserDto user) {
        userRepository.save(userMapper.toEntity(user));
    }

    @Override
    public void deleteUserById(Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found with id: " + userId));
        userRepository.delete(user);
    }
}
