package com.sstufinder.main.service;

import com.sstufinder.main.repository.StudentInfo;
import com.sstufinder.main.repository.StudentRepository;
import com.sstufinder.main.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    TeacherRepository teacherRepository;

    public Object findById(long id, String role) {
        if (role.equals("student")){
            StudentInfo asd = studentRepository.findById(id);
            return studentRepository.findById(id); }
        else{ return teacherRepository.findById(id); }
    }
}
