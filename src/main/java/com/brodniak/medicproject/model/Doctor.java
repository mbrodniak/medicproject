package com.brodniak.medicproject.model;

public class Doctor {

    int DoctorId;
    String specialisation;
    String firstName;
    String lastName;


    public Doctor(int DoctorId, String specialisation, String firstName, String lastName) {
        this.DoctorId = DoctorId;
        this.specialisation = specialisation;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getDoctorId() {
        return DoctorId;
    }

    public void setDoctorId(int doctorId) {
        this.DoctorId = doctorId;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
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

    @Override
    public String toString() {
        return "Doctor{" +
                "DoctorId=" + DoctorId +
                ", specialisation='" + specialisation + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName +
                '}';
    }
}
