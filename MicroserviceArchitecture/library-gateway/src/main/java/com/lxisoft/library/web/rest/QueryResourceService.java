package com.lxisoft.library.web.rest;

import java.util.List;
import java.util.Optional;

import com.lxisoft.library.client.library.api.BookResourceApi;
import com.lxisoft.library.client.library.api.CategoryResourceApi;
import com.lxisoft.library.client.library.model.Book;
import com.lxisoft.library.client.library.model.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class QueryResourceService {

    @Autowired
    private BookResourceApi bookResourceApi;
    @Autowired
    private CategoryResourceApi categoryResourseApi;
    

    @GetMapping("/books")
    public ResponseEntity<List<Book>> findAllBooks() {
        return this.bookResourceApi.getAllBooksUsingGET();
    }

    @PostMapping("/books")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        return this.bookResourceApi.createBookUsingPOST(book);
    }
    @GetMapping("/category")
    public ResponseEntity<List<Category>> findAllCategory() {
        return this.categoryResourseApi.getAllCategoriesUsingGET();
    }

    @PostMapping("/category")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        return this.categoryResourseApi.createCategoryUsingPOST(category);
    }
}