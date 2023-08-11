package com.api.book.botrestbook.services;

import com.api.book.botrestbook.dao.BookRepository;
import com.api.book.botrestbook.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookService {
    @Autowired
    private BookRepository bookRepository;
//    private static List<Book> list = new ArrayList<>();
//
//    static {
//        list.add(new Book(121,"Squet Little", "James"));
//        list.add(new Book(821,"Ramayan", "Tulsidas"));
//        list.add(new Book(876,"C Complete Course", "Kernal"));
//    }

    //get all books
    public List<Book> getAllBooks(){
        List<Book> list = (List<Book>)this.bookRepository.findAll();
        return list;
    }


    //get a single book
    public Book getBookById(int id){
        Book book = null;
        try {
//            book = list.stream().filter(e -> e.getId() == id).findFirst().get();
            book = this.bookRepository.findById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return book;
    }

    public Book addBook(Book b){
       Book result = bookRepository.save(b);
        return result;
    }

    public void deleteBook(int bid){
//      list =  list.stream().filter(book->book.getId() != bid).collect(Collectors.toList());
        bookRepository.deleteById(bid);
    }

    public void updateBook(Book book, int bookId){
//       list = list.stream().map(b->{
//            if(b.getId() == bookId){
//                b.setTitle(book.getTitle());
//                b.setAuthour(book.getAuthour()
//                ;
//            }
//            return b;
//        }).collect(Collectors.toList());
        book.setId(bookId);
        bookRepository.save(book);
    }
}
