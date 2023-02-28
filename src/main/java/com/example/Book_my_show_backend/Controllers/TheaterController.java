package com.example.Book_my_show_backend.Controllers;


import com.example.Book_my_show_backend.Dtos.TheaterRequestDto;
import com.example.Book_my_show_backend.Repository.TheaterRepository;
import com.example.Book_my_show_backend.Repository.TheaterSeatRepository;
import com.example.Book_my_show_backend.Service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theater")
public class TheaterController {
    @Autowired
    TheaterService theaterService;
    @PostMapping("/add")
    public ResponseEntity<String> addTheater(@RequestBody TheaterRequestDto theaterRequestDto){
       String result=  theaterService.crateTheater(theaterRequestDto);
       return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
