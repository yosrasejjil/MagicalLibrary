package com.example.MagicalLibraryy.models;


import lombok.Data;

import javax.persistence.*;

@Data
    @Entity
    @Table
    public class Book {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long bookId;
        private String title;
        private String description;
        private String Auther;
        private float Price;
        @ManyToOne (fetch =FetchType.LAZY)
        @JoinColumn(name = "genreId",referencedColumnName = "genreId")
        private Genres genre ;
        private String ImageName;



    }