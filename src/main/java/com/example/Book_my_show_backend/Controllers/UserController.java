package com.example.Book_my_show_backend.Controllers;


import com.example.Book_my_show_backend.Dtos.UserRequestDto;
import com.example.Book_my_show_backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserService userService;


    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody()UserRequestDto userRequestDto){
        String result=userService.createUser(userRequestDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);

    }
}
