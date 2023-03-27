package com.damjanh.climbtracker.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "route")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "route_id")
    private long id;
    @Column(name = "route_title")
    private String title;
    @Column(name = "route_description")
    private String description;
    @Column(name = "route_length")
    private int lengthMeters;
    @Enumerated(EnumType.STRING)
    @Column(name = "route_dificulty")
    private Dificulty dificulty;

    private Route() {
        // Hidden
    }

    public Route(String title, String description, int lengthMeters, Dificulty dificulty) {
        this.title = title;
        this.description = description;
        this.lengthMeters = lengthMeters;
        this.dificulty = dificulty;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLengthMeters() {
        return lengthMeters;
    }

    public void setLengthMeters(int lengthMeters) {
        this.lengthMeters = lengthMeters;
    }

    public Dificulty getDificulty() {
        return dificulty;
    }

    public void setDificulty(Dificulty dificulty) {
        this.dificulty = dificulty;
    }
}
