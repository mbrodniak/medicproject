package com.brodniak.medicproject.controller;

import com.brodniak.medicproject.entity.Appointment;
import com.brodniak.medicproject.repository.AppointmentRepository;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/medicproject/appointment")
public class AppointmentController {

    @Autowired
    public AppointmentRepository appointmentRepository;

    @GetMapping(path = "/getBy")
    public List<Appointment> getAppointmentByDoctorIdAndDate(@RequestParam Timestamp start, @RequestParam Timestamp end, @RequestParam int id) {
        System.out.println(start +", " + end);
        return appointmentRepository.findByDateBetweenAndDoctorId(start, end, id);
    }

    @GetMapping(path = "/getByDate")
    public List<Appointment> getByDate(@RequestParam Date date) {
        return appointmentRepository.findByDateBefore(date);
    }

    @PostMapping(path = "/add")
    public Appointment makeAnAppointment(@RequestBody Appointment appointment){
        appointment.setDate(new Timestamp(appointment.getDate().getTime() + 7200000));//add 2 hours
        return appointmentRepository.save(appointment);
    }

    @GetMapping(path = "/all")
    public List<Appointment> getAll(){

        return appointmentRepository.findAll();
    }

    @GetMapping(path = "/closestAppointment")
    public List<Appointment> getClosestAppointmentByDate(){
        return null;
    }

    @GetMapping(path = "/getAllByDate")
    public ArrayList<Appointment> getAllByDate(@RequestParam Timestamp startDate, Timestamp endDate){
        return appointmentRepository.findAllByDateBetween(startDate,endDate);
    }

}
