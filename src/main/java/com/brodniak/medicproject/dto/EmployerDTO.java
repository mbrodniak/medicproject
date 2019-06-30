package com.brodniak.medicproject.dto;

import com.brodniak.medicproject.entity.Employer;

public class EmployerDTO {

    private int id;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private boolean enabled;
    private String role;

    public EmployerDTO(Employer employer) {

        this.id = employer.getId();
        this.login = employer.getLogin();
        this.password = employer.getPassword();
        this.firstName = employer.getFirstName();
        this.lastName = employer.getLastName();
        this.enabled = employer.isEnabled();
        this.role = employer.getRole();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "EmployerDTO{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", enabled=" + enabled +
                ", role='" + role + '\'' +
                '}';
    }
}
