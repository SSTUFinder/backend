package com.sstufinder.main.service;

import com.sstufinder.main.exception.*;
import com.sstufinder.main.model.AuthModel;
import com.sstufinder.main.model.StudentModel;
import com.sstufinder.main.model.TeacherModel;

public interface RegistrationAuthService {

    long auth(AuthModel authModel) throws UncorrectLoginException, UncorrectPasswordException;

    long regTeacher(TeacherModel teacherModel) throws ExistingLoginException, ExistingEmailException;

    long regStudent(StudentModel studentModel) throws ExistingLoginException, ExistingEmailException, ExistingRecordBookNumberException;

}
