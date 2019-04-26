package com.brodniak.medicproject.controller;

import com.brodniak.medicproject.entity.Doctor;
import com.brodniak.medicproject.repository.DoctorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/medicproject/doctor")
public class DoctorController {

    @Autowired
    public DoctorRepository doctorRepository;

    @GetMapping(path = "/all")
    public List<Doctor> getAll(){
        return doctorRepository.findAll();
    }

    @GetMapping(path = "/findBy")
    public Doctor getDoctor(@RequestParam Integer id) {
        return doctorRepository.findByDoctorId(id);
    }

}
