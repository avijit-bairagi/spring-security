package com.ovi.app.controller;

import com.ovi.app.payload.ResponseBody;
import com.ovi.app.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/all")
    public ResponseBody getUsers() {

        ResponseBody responseBody = new ResponseBody();
        responseBody.setSuccess(true);
        responseBody.setMessage("Success!");
        responseBody.setData(userRepository.findAll());

        return responseBody;
    }

}
