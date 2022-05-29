package com.sstufinder.main.service;

import com.sstufinder.main.repository.EventRepository;
import com.sstufinder.main.repository.SimpleEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService{

    @Autowired
    EventRepository eventRepository;

    public List<SimpleEvent> findAll() {
//        java.sql.Connection connection = datasourse.

//        List<EventModel> asd = eventRepository.findAll();
//        List<EventModelventModel> asd = eventRepository.findAllEventWithName();
//        for(EventModel: asd){
//            asd.get().getStudentModels(
//        }
//        return eventRepository.findAll();
//        return eventRepository.findAllEventWithName();
//        List<EventModel> eventModelList = eventRepository.findAll();
//        Map<EventModel, >

        List<SimpleEvent> simpleEventModels = eventRepository.findAllEventWithName();
        return eventRepository.findAllEventWithName();
    }
}
