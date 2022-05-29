package com.sstufinder.main.service;

import com.sstufinder.main.model.EventModel;
import com.sstufinder.main.repository.SimpleEvent;

import java.util.List;

public interface EventService {
    boolean saveEvent(EventModel eventModel, String role, long id);
    List<SimpleEvent> findAll();

    void deleteEvent(long id);
}
