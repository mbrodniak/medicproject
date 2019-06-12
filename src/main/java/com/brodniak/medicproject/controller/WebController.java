package com.brodniak.medicproject.controller;

import com.brodniak.medicproject.dto.UserDTO;
import com.brodniak.medicproject.entity.Appointment;
import com.brodniak.medicproject.repository.AppointmentRepository;
import com.brodniak.medicproject.repository.PatientRepository;
import com.brodniak.medicproject.repository.UserRepository;
import com.brodniak.medicproject.service.PatientService;

import java.security.Principal;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
//import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin("http://localhost:4200")
public class WebController {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    PatientService patientService;

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    UserRepository userRepository;


    @PostMapping(path = "/login")
    public ResponseEntity<UserDTO> login(Principal principal, HttpSession httpSession){

        com.brodniak.medicproject.entity.User authenticatedUser = userRepository.findByUsername(principal.getName());
        UserDTO userDTO = new UserDTO(authenticatedUser);
//        String encode = Base64.getEncoder().encodeToString((userDTO.getUsername() + ":" + userDTO.getPassword()).getBytes());
//        userDTO.setToken("Basic " + encode);
        return ResponseEntity.ok(userDTO);
    }



}
