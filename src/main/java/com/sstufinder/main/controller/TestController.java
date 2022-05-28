package com.sstufinder.main.controller;

import com.sstufinder.main.model.TeacherModel;
import com.sstufinder.main.service.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    TeacherServiceImpl teacherService;

//    @GetMapping("/user")
//    public ResponseEntity<List<TestModel>> findByFirstname(@RequestParam String firstname){
//        return new ResponseEntity<>(testService.findByFirstname(firstname), HttpStatus.OK);
//    }

    @GetMapping("/teacher")
    public String feelTeacherData(){
        TeacherModel teacherModel1 =TeacherModel.builder().login("rinocraft").password("123").firstname("Rinat").lastname("Yagudin").email("rina@gmail.com").build();
        TeacherModel teacherModel2 =TeacherModel.builder().login("qwerty").password("qwe").firstname("Rinat").lastname("Yagudin").email("qwe@gmail.com").build();
        TeacherModel teacherModel3 =TeacherModel.builder().login("zxc").password("zxc").firstname("zxc").lastname("SF").email("zxcSF@gmail.com").build();
        teacherService.saveTeacher(teacherModel1);
        teacherService.saveTeacher(teacherModel2);
        teacherService.saveTeacher(teacherModel3);
        return "Save all test teacher";
    }

}
