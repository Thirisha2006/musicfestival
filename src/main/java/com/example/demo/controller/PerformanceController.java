package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entity.Performance;
import com.example.demo.service.PerformancceService;

@RestController
@RequestMapping("/performances")
public class PerformanceController {
    @Autowired
    private PerformancceService performanceService;

    @GetMapping
    public List<Performance> getAllPerformances() {
        return performanceService.getAllPerformances();
    }

    @GetMapping("/{id}")
    public Performance getPerformanceById(@PathVariable Long id) {
        return performanceService.getPerformanceById(id);
    }

   
    @PostMapping
    public Performance createPerformance(@RequestBody Performance performance) {
        return performanceService.createPerformance(performance);
    }

   
    @PutMapping("/{id}")
    public Performance updatePerformance(@PathVariable Long id, @RequestBody Performance updatedPerformance) {
        return performanceService.updatePerformance(id, updatedPerformance);
    }

    @DeleteMapping("/{id}")
    public String deletePerformance(@PathVariable Long id) {
        performanceService.deletePerformance(id);
        return "Performance deleted successfully!";
    }
    @GetMapping("/page")
    public Page<Performance> getPerformancesByPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return performanceService.getPerformancesByPage(page, size);
    }
    @GetMapping("/sort")
    
    
public List<Performance> sortByPerformance() {
    return performanceService.sortByPerformance();
}

}
