package com.sstufinder.main.controller;


import com.sstufinder.main.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//выбрасывалась инфа
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @PutMapping("/{id}")
    ResponseEntity<String> saveReason(@PathVariable String id, @RequestParam String reason ){
        userService.saveReason(Long.parseLong(id), reason);
        return ResponseEntity.ok().body("Ваша причина была услышана. В ближайшее время ее расмотрим");
    }


    @GetMapping("/{id}")
    ResponseEntity<Object> findById(@PathVariable String id, @RequestParam String role){

        Object asd = userService.findById(Long.parseLong(id), role);
        return ResponseEntity.ok(userService.findById(Long.parseLong(id), role));
    }
}
