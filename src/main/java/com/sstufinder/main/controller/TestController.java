package com.sstufinder.main.controller;

import com.sstufinder.main.model.EventModel;
import com.sstufinder.main.model.StudentModel;
import com.sstufinder.main.model.TeacherModel;
import com.sstufinder.main.repository.EventRepository;
import com.sstufinder.main.repository.StudentRepository;
import com.sstufinder.main.repository.TeacherRepository;
import com.sstufinder.main.service.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    EventRepository eventRepository;


    @GetMapping("/data")
    public String feelTeacherData(){

        TeacherModel teacherModel1 =TeacherModel.builder().login("rinocraft").password("123").firstname("Rinat").lastname("Yagudin").email("rina@gmail.com").build();
        TeacherModel teacherModel2 =TeacherModel.builder().login("qwerty").password("qwe").firstname("Rinat").lastname("Yagudin").email("qwe@gmail.com").build();
        TeacherModel teacherModel3 =TeacherModel.builder().login("zxc").password("zxc").firstname("zxc").lastname("SF").email("zxcSF@gmail.com").build();

        StudentModel studentModel1 = StudentModel.builder().login("rinocraft").password("123").firstname("Rinat").lastname("Yagudin").email("rina@gmail.com").recordBookNumber("193300").upgradeTier(true).build();
        StudentModel studentModel2 = StudentModel.builder().login("student1").password("qwe").firstname("Denis").lastname("qwe").email("qweee@gmail.com").recordBookNumber("193301").upgradeTier(false).build();
        StudentModel studentModel3 = StudentModel.builder().login("student2").password("zxc").firstname("Rinat").lastname("zxc").email("zxccc@gmail.com").recordBookNumber("193302").upgradeTier(false).build();


        EventModel eventModel1 = EventModel.builder().place("1:416").publicationTime(new Timestamp(2022, 05, 05, 8,00, 00,0)).timeSpending(new Timestamp(2022, 05, 05, 18,00, 00,0)).studentModel(studentModel1).build();
        EventModel eventModel2 = EventModel.builder().place("1:417").publicationTime(new Timestamp(2022, 05, 10, 8,00, 00,0)).timeSpending(new Timestamp(2022, 05, 10, 18,00, 00,0)).studentModel(studentModel1).build();
        EventModel eventModel3 = EventModel.builder().place("1:418").publicationTime(new Timestamp(2022, 05, 20, 8,00, 00,0)).timeSpending(new Timestamp(2022, 05, 20, 18,00, 00,0)).teacherModel(teacherModel3).build();



//        studentModel1.setEventModels(Arrays.asList(eventModel1, eventModel2));
////        studentModel1.setEventModelList(Arrays.asList(eventModel2));
//        teacherModel3.setEventModels(Arrays.asList(eventModel3));

        eventRepository.save(eventModel1);
        eventRepository.save(eventModel2);
        eventRepository.save(eventModel3);

        studentRepository.save(studentModel1);
        studentRepository.save(studentModel2);
        studentRepository.save(studentModel3);

        teacherRepository.save(teacherModel1);
        teacherRepository.save(teacherModel2);
        teacherRepository.save(teacherModel3);
        return "ALl save";
    }

}
