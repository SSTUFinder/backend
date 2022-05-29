package com.sstufinder.main.controller;

import com.sstufinder.main.repository.SimpleEvent;
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
    public ResponseEntity<List<SimpleEvent>> findAll(){
        return ResponseEntity.ok(eventService.findAll());
    }
}
