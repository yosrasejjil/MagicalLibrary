package com.example.MagicalLibraryy.controllers;


import com.example.MagicalLibraryy.DTO.BookDTO;
import com.example.MagicalLibraryy.models.Book;
import com.example.MagicalLibraryy.models.Genres;
import com.example.MagicalLibraryy.services.BookService;
import com.example.MagicalLibraryy.services.GenresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Controller
public class AdminController {
   public static String uploadDir=System.getProperty("user.dir")+"/src/main/resources/static/BookImages";
    @Autowired
    GenresService genresService;
    @Autowired
    BookService bookService;
    
    @GetMapping("/admin")
    public String adminHome(){
        return "AdminHome";
    }

    @GetMapping("/admin/genres")
    public String adminGenre(Model model){
        model.addAttribute("lesgenres",genresService.getAllGenres());
        return "genre";
    }
    @GetMapping("/admin/genres/add")
    public String getGenreAdd(Model model){
        model.addAttribute("genra", new Genres());
        return "GenreAdd";}

    @PostMapping("/admin/genres/add")
            public String postGenreAdd(@ModelAttribute("genra")Genres genre){
            genresService.addGenre(genre);
            return "redirect:/admin/genres";
}
    @GetMapping("/admin/genres/delete/{id}")
    public String deleteGenre(@PathVariable long id) {
        genresService.removeGenreByld(id);
        return "redirect:/admin/genres"; }

    @GetMapping("/admin/genres/update/{id}")
    public String updateCat(@PathVariable long id, Model model) {
        Optional<Genres> genre = genresService.getGenreByld(id);
        {
            if (genre.isPresent()) {
                model.addAttribute("genra", genre.get());
                return "GenreAdd";
            } else
                return "404";
        }
    }
////// jaw leproduitttt

    @GetMapping ("/admin/Books")
    public String Books(Model model) {
        model.addAttribute( "ktob", bookService.getAllBooks());
        return "Books";}



        @GetMapping("/admin/Books/add")
        public String BookAddGet(Model model) {
            model.addAttribute( "BookDTO", new BookDTO());
            model.addAttribute( "lesGenres", genresService.getAllGenres());
        return "BookAdd";}

            @PostMapping("/admin/Books/add")
            public String BookAddPost(@ModelAttribute("BookDTO") BookDTO BookDTO , @RequestParam("BookImage") MultipartFile file, @RequestParam("imgName")String imgName) throws IOException {
                Book Book = new Book();
                Book.setBookId(BookDTO.getBookId());
                Book.setTitle(BookDTO.getTitle());
                Book.setGenre(genresService.getGenreByld(BookDTO.getGenreId()).get());
                Book.setPrice(BookDTO.getPrice());
                Book.setDescription(BookDTO.getDescription());
                String imageUUID;
                if(!file.isEmpty()) {
                    imageUUID =file.getOriginalFilename();
                    Path fileNameAndPath = Paths.get(uploadDir, imageUUID);
                    Files.write(fileNameAndPath, file.getBytes());
                } else {
                    imageUUID = imgName;
                }
                Book.setImageName(imageUUID);
                bookService.addBook(Book);
                return "redirect:/admin/Books"; }

    // public String deleteProduct(@PathVariable long id) {
//        productservice.removeProductByld(id);
//        return “redirect:/adnin/products" ;}
//
//        pGetMapping(“/adrain/product/update/{id}M)
//        public String updateProductGet(@PathVariable long id. Model model) {
//            Product product = productService.getProductByld(id).get();
//            ProductDTO productDTO = new ProductOTOO;
//            productDTO.setld(product.getldO);
//            productDTO.setNane(product.getNameO);
//            productDTO.setCategoryId((product.getCategory().getId()));
//            productDTO.setPrice(product.getPriceO);
//            productDTO.setweight((product.getWeightO));
//            productDTO. setOescription (product. getOescriptionO);
//            productDTO.setImageName(product. getImageNaneO);
//            model.addAttribute( ttr .	"categories”, categoryService.getAHCategoryO);
//                    model.addAttribute( ttfbjtcNam. “productDTO”, productDTO);
//            return "productsAdd";
//







}












