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

import com.example.demo.entity.Artist;
import com.example.demo.service.ArtistService;

@RestController
@RequestMapping("/artists")
public class ArtistController {
    @Autowired
    private ArtistService artistService;

    @GetMapping
    public List<Artist> getAllArtists() {
        return artistService.getAllArtists();
    }

    @GetMapping("/{id}")
    public Artist getArtistById(@PathVariable Long id) {
        return artistService.getArtistById(id);
    }

    @PostMapping
    public Artist createArtist(@RequestBody Artist artist) {
        return artistService.createArtist(artist);
    }

    @PutMapping("/{id}")
    public Artist updateArtist(@PathVariable Long id, @RequestBody Artist updatedArtist) {
        return artistService.updateArtist(id, updatedArtist);
    }

    @DeleteMapping("/{id}")
    public String deleteArtist(@PathVariable Long id) {
        artistService.deleteArtist(id);
        return "Artist deleted successfully!";
    }

    @GetMapping("/page")
    public Page<Artist> getArtistsByPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        return artistService.getArtistsByPage(page, size);
    }

    @GetMapping("/sort")
    public List<Artist> getArtistsSorted(
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {
        return artistService.getArtistsSorted(sortBy, direction);
    }

    
    @GetMapping("/genre/{genre}")
    public List<Artist> getArtistsByGenre(@PathVariable String genre) {
        return artistService.getArtistsByGenre(genre);
    }
    
}
