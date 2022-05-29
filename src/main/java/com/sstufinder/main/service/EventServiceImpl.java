package com.sstufinder.main.service;

import com.sstufinder.main.model.AllEventModel;
import com.sstufinder.main.model.EventModel;
import com.sstufinder.main.repository.EventRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService{

    @Autowired
    EventRepository eventRepository;

    public List<EventModel> findAll() {
//        java.sql.Connection connection = datasourse.

        List<EventModel> asd = eventRepository.findAll();

        return eventRepository.findAll();
//        List<EventModel> eventModelList = eventRepository.findAll();
//        Map<EventModel, >
    }
}
