package com.brodniak.medicproject.controller;

import com.brodniak.medicproject.dto.PatientDTO;
import com.brodniak.medicproject.dto.UserDTO;
import com.brodniak.medicproject.entity.Patient;
import com.brodniak.medicproject.entity.User;
import com.brodniak.medicproject.repository.PatientRepository;
import com.brodniak.medicproject.repository.UserRepository;
import com.brodniak.medicproject.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/medicproject/patient")
public class PatientController {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    PatientService patientService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JavaMailSender javaMailSender;

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public List<Patient> getAll() {
        return patientRepository.findAll();
    }

    @GetMapping(path = "/userAll")
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @GetMapping(path = "/findUserById")
    public User findUserById(@RequestParam int id){
        return userRepository.findById(id);
    }

    @PostMapping("/add")
    public String addPatient(@RequestParam("file") MultipartFile file, @RequestBody PatientDTO patientDTO) {
        try {
            System.out.println(patientDTO);
            patientRepository.save(patientService.patientRegistration(patientDTO));
            if(file != null){
                File newFile = new File(file.getOriginalFilename());
                newFile.createNewFile();
                FileOutputStream output = new FileOutputStream(newFile);
                output.write(file.getBytes());
                output.close();

                MimeMessage message = javaMailSender.createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(message, true);

                helper.setTo("brodniakmichal@gmail.com");
                helper.setSubject("Test");
                helper.setText("Testowa wiadomosc");

                FileSystemResource fileSystemResource = new FileSystemResource(newFile);
                helper.addAttachment("Zalacznik", fileSystemResource);
                javaMailSender.send(message);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "";
    }
}
