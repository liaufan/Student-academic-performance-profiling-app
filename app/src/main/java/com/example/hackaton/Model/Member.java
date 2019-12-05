package com.example.hackaton.Model;

public class Member {
    private String username;
    private String password;
    private String name;
    private int grade;
    private int status;
    private String email;
    private int star;

    public Member() {
    }

    public Member(String username, String password, String name, int grade, int status, String email, int star) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.grade = grade;
        this.status = status;
        this.email = email;
        this.star = star;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

