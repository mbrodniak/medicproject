package com.brodniak.medicproject.entity;

import com.brodniak.medicproject.dto.PatientDTO;

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
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

    public Patient() {

    }

    public Patient(PatientDTO patientDTO) {

        this.patientId = patientDTO.getPatientId();
        this.firstName = patientDTO.getFirstName();
        this.lastName = patientDTO.getLastName();
        this.birthDate = patientDTO.getBirthDate();
        this.ability = patientDTO.isAbility();
        this.email = patientDTO.getEmail();
        this.password = patientDTO.getPassword();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
