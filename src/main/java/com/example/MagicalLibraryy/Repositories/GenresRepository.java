package com.example.MagicalLibraryy.Repositories;

import com.example.MagicalLibraryy.models.Genres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenresRepository extends JpaRepository<Genres,Long> {

}
