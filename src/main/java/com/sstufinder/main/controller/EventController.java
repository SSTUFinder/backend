package com.sstufinder.main.controller;

import com.sstufinder.main.model.EventModel;
import com.sstufinder.main.repository.SimpleEvent;
import com.sstufinder.main.service.EventServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    EventServiceImpl eventService;

    @GetMapping("/")
    public ResponseEntity<List<SimpleEvent>> findAll(){
        return ResponseEntity.ok(eventService.findAll());
    }

    //просто по id удалить event
    @PostMapping("/add")
    public ResponseEntity<String> saveEvent(@RequestBody EventModel eventModel, @RequestParam String id, @RequestParam String role){
        if (!eventService.saveEvent(eventModel, role, Long.parseLong(id))) {
            return ResponseEntity.ok().body("Мероприятие успешно добавлено");
        }
        else{return ResponseEntity.badRequest().body("Ошибка в добавлении мероприятия");
        }
    }
}
