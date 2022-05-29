package com.sstufinder.main.repository;

import com.sstufinder.main.model.StudentModel;

public interface SimpleEvent {
    long getId();
    String getTitle();
    String getDescription();
    String getPlace();
    java.util.Date getTimeSpending();
    java.util.Date getPublicationTime();
    StudentName getStudentModel();
    TeacherName getTeacherModel();
}
