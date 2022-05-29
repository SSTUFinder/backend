package com.sstufinder.main.controller;

import com.sstufinder.main.model.EventModel;
import com.sstufinder.main.model.StudentModel;
import com.sstufinder.main.model.TeacherModel;
import com.sstufinder.main.repository.EventRepository;
import com.sstufinder.main.repository.StudentRepository;
import com.sstufinder.main.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;


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
    public String feelTeacherData() throws ParseException {


        TeacherModel teacherModel1 =TeacherModel.builder().login("rinocraft").password("123").firstname("Rinat").lastname("Yagudin").email("rina@gmail.com").build();
        TeacherModel teacherModel2 =TeacherModel.builder().login("qwerty").password("qwe").firstname("Rinat").lastname("Yagudin").email("qwe@gmail.com").build();
        TeacherModel teacherModel3 =TeacherModel.builder().login("zxc").password("zxc").firstname("zxc").lastname("SF").email("zxcSF@gmail.com").build();

        StudentModel studentModel1 = StudentModel.builder().login("rinocraft").password("123").firstname("Rinat").lastname("Yagudin").email("rina@gmail.com").recordBookNumber("193300").upgradeTier(true).build();
        StudentModel studentModel2 = StudentModel.builder().login("student1").password("qwe").firstname("Denis").lastname("qwe").email("qweee@gmail.com").recordBookNumber("193301").build();
        StudentModel studentModel3 = StudentModel.builder().login("student2").password("zxc").firstname("Rinat").lastname("zxc").email("zxccc@gmail.com").recordBookNumber("193302").build();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        EventModel eventModel1 = EventModel.builder().title("День программиста").
                description("Тут мы прозднуем день косманавта, приходи").
                place("1/416").
                publicationTime(simpleDateFormat.parse("2022-05-15 08:00:00")).
                timeSpending(simpleDateFormat.parse("2022-05-20 18:00:00")).
                studentModel(studentModel1).build();

        EventModel eventModel2 = EventModel.builder().title("День заОЧниКОв").
                description("Ты появляешься раз в полгода?. Ну так загляни еще раз, но пораньше. Ждем вас заОЧниКОв").
                place("1/417").
                publicationTime(simpleDateFormat.parse("2022-05-05 08:00:00")).
                timeSpending(simpleDateFormat.parse("2022-05-09 18:00:00")).
                studentModel(studentModel1).build();

        EventModel eventModel3 = EventModel.builder().title("День очника").
                description("Устал ходить на пары, ну так приди к нам, у нас тут плойка и телек большой и диваны удобные.").
                place("1/418").
                publicationTime(simpleDateFormat.parse("2022-05-01 08:00:00")).
                timeSpending(simpleDateFormat.parse("2022-05-30 18:00:00")).
                studentModel(studentModel1).build();

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
