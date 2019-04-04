package com.brodniak.medicproject.controller;

import com.brodniak.medicproject.entity.Patient;
import com.brodniak.medicproject.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/medicproject/patient")
public class PatientController {

    @Autowired
    PatientRepository patientRepository;

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public List<Patient> getAll(){
        return patientRepository.findAll();
    }


}
