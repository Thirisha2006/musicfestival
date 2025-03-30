/*package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Performance;
import com.example.demo.repository.PerformanceRepository;

@Service
public class PerformancceService {
     @Autowired
    private PerformanceRepository performanceRepository;

   
    public List<Performance> getAllPerformances() {
        return performanceRepository.findAll();
    }

    
    public Performance getPerformanceById(Long id) {
        Optional<Performance> performance = performanceRepository.findById(id);
        return performance.orElse(null);
    }

   
    public Performance createPerformance(Performance performance) {
        return performanceRepository.save(performance);
    }

    
    public Performance updatePerformance(Long id, Performance updatedPerformance) {
        if (performanceRepository.existsById(id)) {
            updatedPerformance.setId(id);
            return performanceRepository.save(updatedPerformance);
        }
        return null;
    }

    
    public void deletePerformance(Long id) {
        performanceRepository.deleteById(id);
    }
    public Page<Performance> getPerformancesByPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return performanceRepository.findAll(pageable);
    }
    public List<Performance> sortByPerformance() {
        return performanceRepository.findAll(Sort.by("startTime").ascending());
    }
    
    
}
*/


package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.example.demo.entity.Performance;
import com.example.demo.entity.Artist;
import com.example.demo.repository.PerformanceRepository;
import com.example.demo.repository.ArtistRepository;

@Service
public class PerformanceService {
    @Autowired
    private PerformanceRepository performanceRepository;

    @Autowired
    private ArtistRepository artistRepository;

    public List<Performance> getAllPerformances() {
        return performanceRepository.findAll();
    }

    public Performance getPerformanceById(Long id) {
        return performanceRepository.findById(id).orElse(null);
    }

    public Performance createPerformance(Performance performance, Long artistId) {
        Optional<Artist> artist = artistRepository.findById(artistId);
        if (artist.isPresent()) {
            performance.setArtist(artist.get());
            return performanceRepository.save(performance);
        } else {
            throw new RuntimeException("Artist not found with ID: " + artistId);
        }
    }

    public Performance updatePerformance(Long id, Performance updatedPerformance) {
        if (performanceRepository.existsById(id)) {
            updatedPerformance.setId(id);
            return performanceRepository.save(updatedPerformance);
        }
        return null;
    }

    public void deletePerformance(Long id) {
        performanceRepository.deleteById(id);
    }
}
