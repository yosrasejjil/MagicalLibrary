package com.example.MagicalLibraryy.models;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Genres {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="genreId")
    private long genreId ;
    @Column(name="genreName")
    private String genreName;
//
//   @OneToMany(fetch= FetchType.LAZY)
//    private Set<Book> books = new HashSet<Book>();
//
//
//    public Genres(String genreName) {
//        super();
//        this.genreName= genreName;
//        this.books = new HashSet<Book>();
    }



