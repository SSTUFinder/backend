package com.sstufinder.main.service;

import com.sstufinder.main.exception.*;
import com.sstufinder.main.model.AuthModel;
import com.sstufinder.main.model.StudentModel;
import com.sstufinder.main.model.TeacherModel;
import com.sstufinder.main.repository.StudentRepository;
import com.sstufinder.main.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class RegistrationAuthServiceImpl implements RegistrationAuthService {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    TeacherRepository teacherRepository;

    public long regStudent(StudentModel studentModel) throws ExistingLoginException, ExistingEmailException, ExistingRecordBookNumberException {
        if (studentRepository.existsByLogin(studentModel.getLogin())){ throw new ExistingLoginException();}
        if (studentRepository.existsByEmail(studentModel.getEmail())){ throw new ExistingEmailException();}
        if (studentRepository.existsByRecordBookNumber(studentModel.getRecordBookNumber())){ throw new ExistingRecordBookNumberException();}
        return studentRepository.save(studentModel).getId();

}

    public long regTeacher(TeacherModel teacherModel) throws ExistingLoginException, ExistingEmailException {
        if (teacherRepository.existsByLogin(teacherModel.getLogin())){ throw new ExistingLoginException();}
        if (teacherRepository.existsByEmail(teacherModel.getEmail())){ throw new ExistingEmailException();}
        return teacherRepository.save(teacherModel).getId();

    }

    public long auth(AuthModel authModel) throws UncorrectLoginException, UncorrectPasswordException {
        if (authModel.getRole().equals("student")){
            StudentModel studentModel = studentRepository.findByLogin(authModel.getLogin());

            if (Objects.isNull(studentModel)) { throw new UncorrectLoginException(); }
            if (authModel.getPassword().equals(studentModel.getPassword())){ return studentModel.getId(); }
            else { throw new UncorrectPasswordException(); }

        }else {
            TeacherModel teacherModel = teacherRepository.findByLogin(authModel.getLogin());

            if (Objects.isNull(teacherModel)) { throw new UncorrectLoginException(); }
            if (authModel.getPassword().equals(teacherModel.getPassword())){ return teacherModel.getId(); }
            else { throw new UncorrectPasswordException(); }

        }
    }

}
