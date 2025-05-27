package com.example.salescarpremium.services.impl;

import com.example.salescarpremium.dao.UserDAO;
import com.example.salescarpremium.dtos.UserDTO;
import com.example.salescarpremium.entities.User;
import com.example.salescarpremium.services.interfaces.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<UserDTO> findAllService() {
        return userDAO.findAll()
                .stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .toList();
    }

    @Override
    public Optional<UserDTO> findOneService(Long id) {
        return userDAO.findById(id)
                .map(user -> modelMapper.map(user, UserDTO.class));
    }

    @Override
    public UserDTO saveService(UserDTO userDTO) {
        return modelMapper.map(
                userDAO.save(modelMapper.map(userDTO, User.class)),
                UserDTO.class
        );
    }
}
