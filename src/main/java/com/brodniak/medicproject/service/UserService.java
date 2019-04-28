package com.brodniak.medicproject.service;

import com.brodniak.medicproject.dto.UserDTO;
import com.brodniak.medicproject.entity.User;
import com.brodniak.medicproject.repository.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    public UserRepository userRepository;

    public List<UserDTO> getUsers() {
        List<UserDTO> userDTOList = null;
        List<User> userList = userRepository.findAll();
        for (User user : userList) {
            userDTOList.add(new UserDTO(user));
        }
        return userDTOList;
    }


}
