package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Artist;
import com.example.demo.repository.ArtistRepository;

@Service
public class ArtistService {
    

    @Autowired
    private ArtistRepository artistRepository;

    public List<Artist> getAllArtists() {
        return artistRepository.findAll();
    }

    public Artist getArtistById(Long id) {
        return artistRepository.findById(id).orElse(null);
    }

    public Artist createArtist(Artist artist) {
        return artistRepository.save(artist);
    }

    public Artist updateArtist(Long id, Artist updatedArtist) {
        if (artistRepository.existsById(id)) {
            updatedArtist.setId(id);
            return artistRepository.save(updatedArtist);
        }
        return null;
    }

    public void deleteArtist(Long id) {
        artistRepository.deleteById(id);
    }

    public Page<Artist> getArtistsByPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return artistRepository.findAll(pageable);
    }

    public List<Artist> getArtistsSorted(String sortBy, String direction) {
        Sort sort = direction.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        return artistRepository.findAll(sort);
    }

    public List<Artist> getArtistsByGenre(String genre) {
        return artistRepository.findArtistsByGenre(genre);
    }
}
