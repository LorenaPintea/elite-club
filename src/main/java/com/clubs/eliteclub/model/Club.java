package com.clubs.eliteclub.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "club")
public class Club implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private double rating;

    public Club(String name) {
        this.name = name;
    }

    public Club() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Club{" +
                "name='" + name + '\'' +
                '}';
    }

}
