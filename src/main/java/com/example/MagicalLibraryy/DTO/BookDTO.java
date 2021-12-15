package com.example.MagicalLibraryy.DTO;

import lombok.Data;

import java.io.Serializable;

@Data
public class BookDTO implements Serializable {
    private Long bookId;
    private String title;
    private String description;
    private String Auther;
    private float Price;
    private String ImageName;
    private long GenreId;

}