package com.brodniak.medicproject;

import java.io.File;

public class Doctor {

    int id;
    String specialisation;
    String firstName;
    String lastName;
    File workTime;


    public Doctor(int id, String specialisation, String firstName, String lastName) {
        this.id = id;
        this.specialisation = specialisation;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public File getWorkTime() {
        return workTime;
    }

    public void setWorkTime(File workTime) {
        this.workTime = workTime;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", specialisation='" + specialisation + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", workTime=" + workTime +
                '}';
    }
}
