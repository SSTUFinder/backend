package com.sstufinder.main.repository;

import com.sstufinder.main.model.StudentModel;

public interface SimpleEvent {
    long getId();
    String getPlace();
    java.util.Date getTimeSpending();
    java.util.Date getPublicationTime();
    StudentName getStudentModel();
    TeacherName getTeacherModel();
}
