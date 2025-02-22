package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Artist;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {
    @Query("SELECT a FROM Artist a WHERE a.genre = :genre")
    List<Artist> findArtistsByGenre(@Param("genre") String genre);
}
