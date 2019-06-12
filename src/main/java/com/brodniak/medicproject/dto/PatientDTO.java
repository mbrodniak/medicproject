package com.brodniak.medicproject.dto;

import java.sql.Date;

public class PatientDTO {

    int patientId;
    String firstName;
    String lastName;
    Date birthDate;
    boolean ability;

    public PatientDTO() {
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

    public boolean isAbility() {
        return ability;
    }

    public void setAbility(boolean ability) {
        this.ability = ability;
    }

    @Override
    public String toString() {
        return "PatientDTO{" +
                "patientId=" + patientId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
//                ", birthDate=" + birthDate +
                ", ability=" + ability +
                '}';
    }
}
