package com.example.hackaton.Model;

public class Subject {
    private int id;
    private String name;
    private int standard;
    private int review;

    public Subject() {
    }

    public Subject(int id, String name, int standard, int review) {
        this.id = id;
        this.name = name;
        this.standard = standard;
        this.review = review;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStandard() {
        return standard;
    }

    public void setStandard(int standard) {
        this.standard = standard;
    }

    public int getReview() {
        return review;
    }

    public void setReview(int review) {
        this.review = review;
    }
}
