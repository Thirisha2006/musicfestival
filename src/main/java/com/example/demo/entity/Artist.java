package com.example.demo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "artists")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    private String name;
    private String genre;


    private String biography;

    
    private String socialMediaLinks; 

    
    private String performanceTime; // Example: "Day 1 - 5:00 PM"

    
    private String stage; 

    
    private String photoUrl; 

  
    public Artist() {}

    public Artist(String name, String genre, String biography, String socialMediaLinks, String performanceTime, String stage, String photoUrl) {
        this.name = name;
        this.genre = genre;
        this.biography = biography;
        this.socialMediaLinks = socialMediaLinks;
        this.performanceTime = performanceTime;
        this.stage = stage;
        this.photoUrl = photoUrl;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getSocialMediaLinks() {
        return socialMediaLinks;
    }

    public void setSocialMediaLinks(String socialMediaLinks) {
        this.socialMediaLinks = socialMediaLinks;
    }

    public String getPerformanceTime() {
        return performanceTime;
    }

    public void setPerformanceTime(String performanceTime) {
        this.performanceTime = performanceTime;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}