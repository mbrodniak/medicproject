package com.brodniak.medicproject.model;

public class Event {

    int eventId;
    String description;
    int patientId;

    public Event() {
    }

    public Event(int eventId, String description, int patientId) {
        this.eventId = eventId;
        this.description = description;
        this.patientId = patientId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId=" + eventId +
                ", description='" + description + '\'' +
                ", patientId=" + patientId +
                '}';
    }
}
