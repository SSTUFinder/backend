package com.diplom.sstufinder.controller;

import com.diplom.sstufinder.model.EventModel;
import com.diplom.sstufinder.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/event")
public class EventController {

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");

    @Autowired
    EventRepository eventRepository;

    @GetMapping
    public String event(){
        return "event";
    }

    @GetMapping("/all")
    public ResponseEntity<List<EventModel>> getAllEvent(){
        return new ResponseEntity<>(eventRepository.getAll(), HttpStatus.OK);
    }

    @GetMapping("/date")
    public ResponseEntity<List<EventModel>> getByDate(){
        java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
        return new ResponseEntity<>(eventRepository.getByDate(date), HttpStatus.OK);
    }
}
