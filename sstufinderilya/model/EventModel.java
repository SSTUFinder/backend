package com.diplom.sstufinder.model;


import java.util.Date;

public class EventModel {

    private Long id;
    private Long id_user_student;
    private String title;
    private Date date;
    private String place;

    public EventModel() {
    }

    public EventModel(Long id, Long id_user_student, String title, Date date, String place) {
        this.id = id;
        this.id_user_student = id_user_student;
        this.title = title;
        this.date = date;
        this.place = place;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_user_student() {
        return id_user_student;
    }

    public void setId_user_student(Long id_user_student) {
        this.id_user_student = id_user_student;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
