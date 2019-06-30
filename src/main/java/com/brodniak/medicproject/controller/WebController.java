package com.brodniak.medicproject.controller;

import com.brodniak.medicproject.dto.EmployerDTO;
import com.brodniak.medicproject.dto.UserDTO;
import com.brodniak.medicproject.entity.Employer;
import com.brodniak.medicproject.entity.Patient;
import com.brodniak.medicproject.repository.AppointmentRepository;
import com.brodniak.medicproject.repository.EmployerRepository;
import com.brodniak.medicproject.repository.PatientRepository;
import com.brodniak.medicproject.repository.UserRepository;
import com.brodniak.medicproject.service.PatientService;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @Autowired
    EmployerRepository employerRepository;


    @PostMapping(path = "/login")
    public ResponseEntity login(Principal principal){

        com.brodniak.medicproject.entity.User authenticatedUser = userRepository.findByUsername(principal.getName());
        UserDTO userDTO = new UserDTO(authenticatedUser);
        if(userDTO.getRole().equals("doctor")){
            return ResponseEntity.ok((userDTO));
        }else if(userDTO.getRole().equals("employer")){
            return ResponseEntity.ok(userDTO);
        }else if(userDTO.getRole().equals("ROLE_USER")){
            Patient patient = patientRepository.findById(userDTO.getId());
            if(!patient.getAbility()){
                return ResponseEntity.status(401).build();
            }
        }
        return ResponseEntity.ok(userDTO);
    }




}