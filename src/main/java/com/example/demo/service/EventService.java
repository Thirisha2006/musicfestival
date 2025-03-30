package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;


import com.example.demo.entity.Event;
import com.example.demo.repository.EventRepository;
@Service
public class EventService {
     @Autowired
    private EventRepository eventRepository;

    
    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    
    public Event getEventById(Long id) {
        Optional<Event> event = eventRepository.findById(id);
        return event.orElse(null);
    }

   
    public Event updateEvent(Long id, Event event) {
        if (eventRepository.existsById(id)) {
            event.setId(id);
            return eventRepository.save(event);
        }
        return null;
    }

  
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    public Page<Event> getEventsByPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return eventRepository.findAll(pageable);
    }
     
    public List<Event> sortByEventName() {
        return eventRepository.findAll(Sort.by("eventName").ascending());
    }
    
    
}




