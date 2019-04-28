package com.brodniak.medicproject.controller;

import com.brodniak.medicproject.dto.UserDTO;
import com.brodniak.medicproject.entity.Patient;
import com.brodniak.medicproject.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/medicproject/patient")
public class PatientController {

    @Autowired
    PatientRepository patientRepository;

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public List<Patient> getAll() {
        return patientRepository.findAll();
    }
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String login(@RequestBody UserDTO user) {
////        System.out.println(user.getEmail()+ ", " + user.getPassword()
////        + ", " + user.getRole());
//        if(user.getEmail().equals("email")){
//            if(user.getPassword().equals("password")){
//                return "/good";
//            }
//            else{
//                return "/false";
//            }
//        }
//        else{
//            return "/false";
//        }
//    }

    @RequestMapping(path = "/validateLogin", method = RequestMethod.GET)
    public UserDTO get() {
//        System.out.println(token);
        UserDTO userDto = new UserDTO();
        System.out.println(userDto.getEmail() + ", " + userDto.getPassword() + ", " + userDto.getRole());

        return userDto;

    }

//    @RequestMapping("/user")
//    public Patient user(HttpServletRequest request) {
//        String authToken = request.getHeader("Authorization")
//                .substring("Basic".length()).trim();
//        return () ->  new String(Base64.getDecoder()
//                .decode(authToken)).split(":")[0];
//    }
}
