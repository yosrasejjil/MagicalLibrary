package com.example.MagicalLibraryy.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Genres {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="genreId")
    private long genreId ;
    @Column(name="genreName")
    private String genreName;

  // @OneToMany(fetch= FetchType.LAZY)
   // private Set<Books> books = new HashSet<Books>();


//    public Genres(String genreName) {
//        super();
//        this.genreName= genreName;
       // this.books = new HashSet<Books>();
    }



