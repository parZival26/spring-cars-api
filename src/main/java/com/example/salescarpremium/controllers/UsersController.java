package com.example.salescarpremium.controllers;

import com.example.salescarpremium.dtos.UserDTO;
import com.example.salescarpremium.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.findAllService();
    }

    @GetMapping("/{id}")
    public Optional<UserDTO> getUserById(@PathVariable Long id) {
        return userService.findOneService(id);
    }

    @PostMapping()
    public UserDTO saveUser(@RequestBody UserDTO userDTO) {
        return userService.saveService(userDTO);
    }
}
