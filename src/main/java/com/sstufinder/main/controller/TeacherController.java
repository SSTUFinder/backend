package com.sstufinder.main.controller;

import com.sstufinder.main.model.TeacherModel;
import com.sstufinder.main.service.TeacherService;
import com.sstufinder.main.service.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    TeacherServiceImpl teacherService;

    @GetMapping("/teach")
    ResponseEntity<TeacherModel> findByLoginPassword(@RequestParam String login, @RequestParam String password){
        return  new ResponseEntity<>(teacherService.findByLoginPassword(login, password), HttpStatus.OK);
    }

}
