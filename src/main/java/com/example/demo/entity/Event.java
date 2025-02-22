package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    private String eventName;

    
    private String description;

    
    private String location;

    
    private String startDate; // Format: YYYY-MM-DD

    
    private String endDate; // Format: YYYY-MM-DD

    
    private String organizerName;

    
    private String festivalTimeline; 

   
    public Event() {}

    public Event(String eventName, String description, String location, String startDate, String endDate, String organizerName, String festivalTimeline) {
        this.eventName = eventName;
        this.description = description;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
        this.organizerName = organizerName;
        this.festivalTimeline = festivalTimeline;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getOrganizerName() {
        return organizerName;
    }

    public void setOrganizerName(String organizerName) {
        this.organizerName = organizerName;
    }

    public String getFestivalTimeline() {
        return festivalTimeline;
    }

    public void setFestivalTimeline(String festivalTimeline) {
        this.festivalTimeline = festivalTimeline;
    }
}
