package com.sstufinder.main.service;

import com.sstufinder.main.model.EventModel;
import com.sstufinder.main.model.StudentModel;
import com.sstufinder.main.repository.EventRepository;
import com.sstufinder.main.repository.SimpleEvent;
import com.sstufinder.main.repository.StudentRepository;
import com.sstufinder.main.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EventServiceImpl implements EventService{

    @Autowired
    EventRepository eventRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    TeacherRepository teacherRepository;

    public List<SimpleEvent> findAll() { return eventRepository.findAllEventWithName(); }

    public boolean saveEvent(EventModel eventModel, String role, long id) {
        if (role.equals("student")){
            eventModel.setStudentModel(studentRepository.findAllById(id));
        }else{
            eventModel.setTeacherModel(teacherRepository.findAllById(id));
        }
        EventModel tmp = eventRepository.save(eventModel);
        if (Objects.isNull(tmp)) {return true;}
        return  false;
    }

    public void deleteEvent(long id) {
        eventRepository.deleteById(id);
    }
}
