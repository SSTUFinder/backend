package com.sstufinder.main.controller;

import com.sstufinder.main.model.EventModel;
import com.sstufinder.main.service.EventService;
import com.sstufinder.main.service.EventServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventController {

    @Autowired
    EventServiceImpl eventService;

    @GetMapping("/events")
    public ResponseEntity<List<EventModel>> findAll(){
        return ResponseEntity.ok(eventService.findAll());
    }
}
