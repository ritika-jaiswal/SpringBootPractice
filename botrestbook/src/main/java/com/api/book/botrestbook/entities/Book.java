package com.api.book.botrestbook.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private int id;
    private String title;
//    private String authour;
    //Nesting Custom Type in SB
    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Author authour;

    public Book(){}

    public Book(int id, String title, Author authour) {
        this.id = id;
        this.title = title;
        this.authour = authour;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthour() {
        return authour;
    }

    public void setAuthour(Author authour) {
        this.authour = authour;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authour='" + authour + '\'' +
                '}';
    }
}
