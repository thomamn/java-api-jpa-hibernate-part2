package com.booleanuk.api.Model;

import jakarta.persistence.*;

@Entity
@Table(name="Authors")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String genre;

    @ManyToOne
    @JoinColumn(name="author_id", nullable = false)
    private Author author;

    @ManyToOne
    @JoinColumn(name="publisher_id", nullable = false)
    private Integer publisher_id;

    public Integer getId() {return id;}

    public String getTitle() {return title;}

    public String getGenre() {return genre;}

    public void setId(Integer id) {this.id = id;}

    public void setTitle(String title) {this.title = title;}

    public void setGenre(String genre) {this.genre = genre;}
}
