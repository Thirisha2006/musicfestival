package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ticket {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String eventName;

    private String userName;

    
    private String ticketNumber;

    
    private String seatNumber;

    
    private String price;

    
    private String status;  

  
    public Ticket() {}

    public Ticket(String eventName, String userName, String ticketNumber, String seatNumber, String price, String status) {
        this.eventName = eventName;
        this.userName = userName;
        this.ticketNumber = ticketNumber;
        this.seatNumber = seatNumber;
        this.price = price;
        this.status = status;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
