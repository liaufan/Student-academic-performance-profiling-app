package com.example.hackaton.Model;

public class MemberSubject {
    private  int id;
    private String memberUsername;
    private int subjectId;
    private String status;
    private int attempt;

    public MemberSubject() {
    }

    public MemberSubject(int id, String memberUsername, int subjectId, String status, int attempt) {
        this.id = id;
        this.memberUsername = memberUsername;
        this.subjectId = subjectId;
        this.status = status;
        this.attempt = attempt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMemberUsername() {
        return memberUsername;
    }

    public void setMemberUsername(String memberUsername) {
        this.memberUsername = memberUsername;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAttempt() {
        return attempt;
    }

    public void setAttempt(int attempt) {
        this.attempt = attempt;
    }
}
