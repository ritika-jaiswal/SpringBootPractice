package com.api.book.botrestbook.Controller;

import com.api.book.botrestbook.entities.Book;
import com.api.book.botrestbook.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

//    @RequestMapping(value = "/books", method = RequestMethod.GET)

    //Get All Books Handler
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks() {
        List<Book> list = bookService.getAllBooks();
        if(list.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }

    //Get a Single Book handler
    @GetMapping("/book/{id}")
    public ResponseEntity <Book> getBook(@PathVariable("id") int id){
        Book book = bookService.getBookById(id);
        if(book == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book));
    }

    //Add Book Handler
    @PostMapping("/books")
    public ResponseEntity<Book>addBook(@RequestBody Book book){
        Book b = null;
        try {
            b = this.bookService.addBook(book);
            return ResponseEntity.of(Optional.of(b));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    //Delete Book Handler
    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable("bookId") int bookId){
        try{
            this.bookService.deleteBook(bookId);
           return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    //Update book handler
    @PutMapping("books/{bookId}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book,@PathVariable("bookId") int bookId){
        try{
            this.bookService.updateBook(book,bookId);
            return ResponseEntity.ok().body(book);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
