package com.api.book.botrestbook.Controller;

import com.api.book.botrestbook.entities.Book;
import com.api.book.botrestbook.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

//    @RequestMapping(value = "/books", method = RequestMethod.GET)

    //Get All Books Handler
    @GetMapping("/books")
    public List<Book> getBooks() {
        return this.bookService.getAllBooks();
    }

    //Get a Single Book handler
    @GetMapping("/book/{id}")
    public Book getBook(@PathVariable("id") int id){
        return bookService.getBookById(id);
    }

    //Add Book Handler
    @PostMapping("/books")
    public Book addBook(@RequestBody Book book){
            Book b = this.bookService.addBook(book);
            return b;
    }

    //Delete Book Handler
    @DeleteMapping("/books/{bookId}")
    public void deleteBook(@PathVariable("bookId") int bookId){
        this.bookService.deleteBook(bookId);
    }

    //Update book handler
    @PutMapping("books/{bookId}")
    public Book updateBook(@RequestBody Book book,@PathVariable("bookId") int bookId){
        this.bookService.updateBook(book,bookId);
        return book;
    }

}
