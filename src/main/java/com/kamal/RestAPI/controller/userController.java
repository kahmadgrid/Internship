package com.kamal.RestAPI.controller;

import com.kamal.RestAPI.dto.UserDTO;
import com.kamal.RestAPI.service.UserService;
import com.kamal.RestAPI.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class userController {
    private final UserServiceImp userServiceImp;

    public userController(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @PostMapping("/user")
    public String createUser(@RequestBody UserDTO userDTO){
        return userServiceImp.createUser(userDTO);
    }

    @GetMapping("/users")
    public List<UserDTO> getAllUsers(){
        return userServiceImp.getAllUser();
    }

    @GetMapping("/user/{id}")
    public UserDTO getUser(@PathVariable Long id){
        return userServiceImp.getUserById(id);
    }
}
