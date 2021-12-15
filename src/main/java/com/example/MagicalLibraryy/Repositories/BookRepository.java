package com.example.MagicalLibraryy.Repositories;

import com.example.MagicalLibraryy.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
  //List<Book> findByGenre_Id(int id);





}
