package com.sstufinder.main.service;

import com.sstufinder.main.model.TeacherModel;
import com.sstufinder.main.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService{

    @Autowired
    TeacherRepository teacherRepository;

//    @Override
//    public String saveTeacher(TeacherModel teacherModel) {
//        teacherRepository.save(teacherModel);
//        return "save";
//    }

//    @Override
//    public TeacherModel findByLoginPassword(String login, String password) {
//
////        return teacherRepository.findByLoginPassword(login);
//    }
}
