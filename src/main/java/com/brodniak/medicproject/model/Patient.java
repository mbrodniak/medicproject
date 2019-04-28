package com.brodniak.medicproject.model;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.Timestamp;

public class Patient {

    int patientId;
    String firstName;
    String lastName;
    Date birthDate;
    boolean ability;
    String email;
    String password;

    public Patient() {

    }


    public Patient(int patientId, String firstName, String lastName, Date birthDate, boolean ability,
                   String email, String password) {
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.ability = ability;
        this.email = email;
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

    public boolean getAbility() {
        return ability;
    }

    public void setAbility(boolean ability) {
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

    public void setPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md5.digest(password.getBytes());
        BigInteger bigInteger = new BigInteger(1, messageDigest);
        this.password = bigInteger.toString(16);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
//                ", birthDate=" + birthDate +
                '}';
    }
}
