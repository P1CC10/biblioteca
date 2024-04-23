package com.develhope.biblioteca.entitis;

import jakarta.persistence.*;

@Entity
public class Book {
    private Object Generation;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
     private String title;
    @Column
    private String author;
    @Column
    private String yearPublication;
    @Column
    private Boolean available;

    public Book() {
    }

    public Book(Object generation, Long id, String title, String author, String yearPublication, Boolean available) {
        Generation = generation;
        this.id = id;
        this.title = title;
        this.author = author;
        this.yearPublication = yearPublication;
        this.available = available;
    }

    public Object getGeneration() {
        return Generation;
    }

    public void setGeneration(Object generation) {
        Generation = generation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYearPublication() {
        return yearPublication;
    }

    public void setYearPublication(String yearPublication) {
        this.yearPublication = yearPublication;
    }

    public Boolean getAvailable() {
        return available;
    }

    public boolean setAvailable(Boolean available) {
        this.available = available;
        return false;
    }
}
