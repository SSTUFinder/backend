package com.sstufinder.main.repository;

import com.sstufinder.main.model.StudentModel;

public interface SimpleEvent {
    long getId();
    String getTitle();
    String getDescription();
    String getPlace();
    String getTime();
    StudentName getStudentModel();
    TeacherName getTeacherModel();
}
