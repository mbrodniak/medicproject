package com.brodniak.medicproject.controller;

import com.brodniak.medicproject.dto.DoctorDTO;
import com.brodniak.medicproject.entity.Doctor;
import com.brodniak.medicproject.repository.DoctorRepository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/medicproject/doctor")
public class DoctorController {

    @Autowired
    public DoctorRepository doctorRepository;

    @GetMapping(path = "/all")
    public List<Doctor> getAll() {
        return doctorRepository.findAll();
    }

    @GetMapping(path = "/findBy")
    public Doctor getDoctor(@RequestParam Integer id) {
        return doctorRepository.findByDoctorId(id);
    }

    @GetMapping(path = "/findBySpecialization")
    public List<DoctorDTO> findBySpecialization(@RequestParam String spec){
        List<Doctor> bySpecialisation = doctorRepository.findBySpecialisation(spec);
        List<DoctorDTO> doctors = new ArrayList<>();
        for (Doctor doctor: bySpecialisation) {
            DoctorDTO doctorDTO = new DoctorDTO(doctor);
            doctors.add(doctorDTO);
        }
        return doctors;
    }





}
