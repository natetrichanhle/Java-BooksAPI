package com.nate.booksapi.controllers;

import java.util.List;

import com.nate.booksapi.models.Book;
import com.nate.booksapi.services.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
    
    @Autowired
    BookService bookService;

    @GetMapping("/books/{bookId}")
    public String showOne(Model model, @PathVariable("bookId") Long bookId){
        System.out.println(bookId);
        Book book = bookService.findBook(bookId);
        System.out.println(book);
        model.addAttribute("book", book);
        return "show.jsp";
    }

    @RequestMapping("/books")
    public String showAll(Model model){
        List<Book> books = bookService.allBooks();
        model.addAttribute("booksList", books);
        return "index.jsp";
    }
    
}
