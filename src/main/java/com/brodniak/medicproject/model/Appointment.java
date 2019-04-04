package com.brodniak.medicproject.model;

import java.sql.Timestamp;

public class Appointment {

    int appointmentId;
    int doctorId;
    Timestamp startDate;
    Timestamp endDate;
    Event event;

    public Appointment() {
    }

    public Appointment(int appointmentId, int doctorId, Timestamp startDate, Timestamp endDate, Event event) {
        this.appointmentId = appointmentId;
        this.doctorId = doctorId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.event = event;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "doctorId=" + doctorId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", event=" + event +
                '}';
    }
}
