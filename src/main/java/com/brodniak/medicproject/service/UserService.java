package com.brodniak.medicproject.service;

import com.brodniak.medicproject.dto.PatientDTO;
import com.brodniak.medicproject.entity.User;
import com.brodniak.medicproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class UserService {

    @Autowired
    PasswordEncoder encoder;

    public User setUser(PatientDTO patientDTO){

        User newUser = new User();
        newUser.setUsername(patientDTO.getEmail());
        newUser.setPassword(encoder.encode(patientDTO.getPassword()));
        newUser.setEnabled(true);
        newUser.setRole("ROLE_USER");
        return newUser;
    }


}
