package com.brodniak.medicproject.entity;

import com.brodniak.medicproject.dto.PatientDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import java.sql.Date;

@Entity(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private int patientId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "birth_date")
    private Date birthDate;
    @Column(name = "ability")
    private Boolean ability;


    @JsonIgnoreProperties({"patient", "doctorId"})
    @OneToMany(mappedBy = "patient")
    private List <Appointment> appointment;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id", insertable = false, updatable = false)
    private User user;

    public Patient() {

    }

    public Patient(PatientDTO patientDTO) {

        this.patientId = patientDTO.getPatientId();
        this.firstName = patientDTO.getFirstName();
        this.lastName = patientDTO.getLastName();
        this.birthDate = patientDTO.getBirthDate();
        this.ability = patientDTO.isAbility();
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean getAbility() {
        return ability;
    }

    public void setAbility(Boolean ability) {
        this.ability = ability;
    }

    public List <Appointment> getAppointment() {
        return appointment;
    }

    public void setAppointment(List <Appointment> appointment) {
        this.appointment = appointment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
