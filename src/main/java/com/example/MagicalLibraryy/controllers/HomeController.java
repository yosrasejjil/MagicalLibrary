package com.example.MagicalLibraryy.controllers;

import com.example.MagicalLibraryy.services.BookService;
import com.example.MagicalLibraryy.services.GenresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    GenresService genresService;
    @Autowired
    BookService bookService;

    @GetMapping({"/","/home"})
    public String home(Model model) { return "index";
    }
    @GetMapping ("/shop")

    public String shop(Model model) {
        model.addAttribute(  "genres", genresService.getAllGenres());
        model.addAttribute(	"books", bookService.getAllBooks());
        return "index";
}
}
