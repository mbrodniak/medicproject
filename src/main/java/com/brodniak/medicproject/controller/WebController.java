package com.brodniak.medicproject.controller;

import com.brodniak.medicproject.dto.PatientDTO;
import com.brodniak.medicproject.repository.PatientRepository;
import com.brodniak.medicproject.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/medicproject/patient")
public class WebController {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    PatientService patientService;

    @PostMapping("/add")
    public String addPatient(@RequestBody PatientDTO patientDTO) {
        try {
            System.out.println(patientDTO);
            patientRepository.save(patientService.patientRegistration(patientDTO));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "";
    }

}
