package com.example.entities;

import javax.persistence.*;

/**
 * Created by noelaniekan on 1/14/17.
 */
@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue
    int id;

    @Column
    String author;

    @Column
    String text;

    @Column
    boolean isGood;

    @ManyToOne
    Lecturer lecturer;

    public Review() {
    }

    public Review(String author, String text, boolean isGood, Lecturer lecturer) {
        this.author = author;
        this.text = text;
        this.isGood = isGood;
        this.lecturer = lecturer;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean getIsGood() {
        return isGood;
    }

    public void setIsGood(boolean isGood) {
        this.isGood = isGood;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
