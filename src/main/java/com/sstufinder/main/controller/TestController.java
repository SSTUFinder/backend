package com.sstufinder.main.controller;

import com.sstufinder.main.model.TestModel;
import com.sstufinder.main.service.TestService;
import com.sstufinder.main.service.TestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    TestServiceImpl testService;

    @GetMapping("/user")
    public ResponseEntity<List<TestModel>> findByFirstname(@RequestParam String firstname){
        return new ResponseEntity<>(testService.findByFirstname(firstname), HttpStatus.OK);
    }

}
