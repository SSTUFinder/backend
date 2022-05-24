package com.diplom.sstufinder.controller;

import com.diplom.sstufinder.SstuFinderApplication;
import com.diplom.sstufinder.model.UserModel;
import com.diplom.sstufinder.repository.UserRepository;
import com.diplom.sstufinder.service.AuthenticationService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(SstuFinderApplication.class);

    private static final Gson gson = new Gson();

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationService authenticationService;

    @GetMapping
    public ResponseEntity<List<UserModel>> getAllUsers() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/reg")
    public String registration() {
        return "registration";
    }

    @PostMapping("/reg")
    public ResponseEntity<Object> createUser(@RequestBody UserModel userModel){
        logger.info("REGISTRATION" + userModel.getFirstname() +userModel.getLastname());
        return new ResponseEntity<>(userRepository.createUser(userModel), HttpStatus.CREATED);

    }

    @GetMapping("/auth")
    public String authentication() {
        return "auth";
    }

    @PostMapping("/auth")
    public ResponseEntity<Object> getByLogin(@RequestBody UserModel userModel, HttpServletResponse response) {
        UserModel userModel1 = userRepository.getByLogin(userModel.getLogin());

        logger.info("user model " + userModel.getLogin() + "    " + userModel.getPassword());
        logger.info("user model1 " + userModel1.getLogin() + "    " + userModel1.getPassword());


        if (userModel1 == null || !userModel.getPassword().equals(userModel1.getPassword())){
            return new ResponseEntity<>(gson.toJson("no token"), HttpStatus.UNAUTHORIZED);
        }


        String token = authenticationService.startSession(userModel1.getId());
        logger.info("getbylogin" + userModel1.getId().toString());
        response.addCookie(new Cookie("token", token));

        return new ResponseEntity<>(gson.toJson(token), HttpStatus.OK);
    }

    @GetMapping("/profile")
    public String profilePage() {
        return "profile";
    }


    @GetMapping("/profile/json")
    public ResponseEntity<Object> profile(@CookieValue(value = "token", required = false) String token){
        logger.info(token);
        Long userId =authenticationService.getUserIdByToken(token);
        logger.info(userId.toString());
        return new ResponseEntity<>(userRepository.getById(userId), HttpStatus.OK);
    }

}