package com.company.restapiexample.service.impl;

import com.company.restapiexample.dto.UserDto;
import com.company.restapiexample.entity.User;
import com.company.restapiexample.exception.UserNotFoundException;
import com.company.restapiexample.mapper.UserMapper;
import com.company.restapiexample.repo.UserRepository;
import com.company.restapiexample.service.inter.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    private UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    @Override
    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();
        return userMapper.toDto(users);
    }

    @Override
    public UserDto findUserById(Integer userId) {
        User user = getUserById(userId);
        return userMapper.toDto(user);
    }

    @Override
    public User getUserById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return (user.get());
        }
        throw new UserNotFoundException("user not found by id" + id);

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
        User user = getUserById(userId);
        userRepository.delete(user);
    }
}
