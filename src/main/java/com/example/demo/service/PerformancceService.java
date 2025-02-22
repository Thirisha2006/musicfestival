package com.example.demo.service;

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
