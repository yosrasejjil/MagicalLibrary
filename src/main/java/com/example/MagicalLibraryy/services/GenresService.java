package com.example.MagicalLibraryy.services;

import com.example.MagicalLibraryy.Repositories.GenresRepository;
import com.example.MagicalLibraryy.models.Genres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenresService {
    @Autowired
    private GenresRepository genreRepository ;
    public List<Genres> getAllGenres(){return genreRepository.findAll();}
    public void addGenre(Genres genre){genreRepository.save(genre);}

    public void removeGenreByld(Long id) {genreRepository.deleteById(id);}

    public Optional<Genres> getGenreByld(long id) { return genreRepository.findById(id);}
}

