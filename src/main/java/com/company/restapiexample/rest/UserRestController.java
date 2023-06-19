package com.company.restapiexample.rest;

import com.company.restapiexample.dto.UserDto;
import com.company.restapiexample.service.inter.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserRestController {
    private final UserService userService;

    @GetMapping("/users")
    public List<UserDto> getUsers() {
        return userService.findAll();
    }

    @GetMapping("/users/{userId}")
    public UserDto getSingleUser(@PathVariable Integer userId) {
        return userService.findUserById(userId);
    }

    @PostMapping("/users")
    public void adduser(@RequestBody UserDto user) {
        user.setId(0);
        userService.addUser(user);
    }

    @PutMapping("/users")
    public void updateUser(@RequestBody UserDto user) {
        userService.addUser(user);
    }


    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable Integer userId) {
        userService.deleteUserById(userId);
    }

}

