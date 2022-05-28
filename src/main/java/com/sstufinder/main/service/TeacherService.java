package com.sstufinder.main.service;

import com.sstufinder.main.model.TeacherModel;

public interface TeacherService {

    TeacherModel findByLoginPassword(String login, String password);

    String saveTeacher(TeacherModel teacherModel);
}
