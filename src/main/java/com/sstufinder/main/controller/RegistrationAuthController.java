package com.sstufinder.main.controller;

import com.sstufinder.main.exception.*;
import com.sstufinder.main.model.AuthModel;
import com.sstufinder.main.model.StudentModel;
import com.sstufinder.main.model.TeacherModel;
import com.sstufinder.main.service.RegistrationAuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegistrationAuthController {

    @Autowired
    RegistrationAuthServiceImpl registrationAuthService;

    @PostMapping("/auth")
    ResponseEntity<Object> auth(@RequestBody AuthModel authModel){
        try {
            long id = registrationAuthService.auth(authModel);
            return ResponseEntity.ok().body(Long.toString(id));
        } catch (UncorrectLoginException e) {
            return ResponseEntity.badRequest().body("Неверный логин:" + authModel.getLogin());
        } catch (UncorrectPasswordException e) {
            return ResponseEntity.badRequest().body("Неверный пароль");
        }
    }

    @PostMapping ("/regTeacher")
    ResponseEntity<Object> reg(@RequestBody TeacherModel teacherModel){
        try {
            return ResponseEntity.ok().body( Long.toString(registrationAuthService.regTeacher(teacherModel)));
        } catch (ExistingLoginException e) {
            return ResponseEntity.badRequest().body("Данный логин уже существует");
        } catch (ExistingEmailException e) {
            return ResponseEntity.badRequest().body("Данная почта уже существует");
        }
    }
    @PostMapping ("/regStudent")
    ResponseEntity<Object> reg(@RequestBody StudentModel studentModel){
        try {
            return ResponseEntity.ok().body(Long.toString(registrationAuthService.regStudent(studentModel)));
        } catch (ExistingLoginException e) {
            return ResponseEntity.badRequest().body("Данный логин уже существует");
        } catch (ExistingEmailException e) {
            return ResponseEntity.badRequest().body("Данная почта уже существует");
        } catch (ExistingRecordBookNumberException e) {
            return ResponseEntity.badRequest().body("Данный номер зачетной книжки уже существует");
        }
    }


}
