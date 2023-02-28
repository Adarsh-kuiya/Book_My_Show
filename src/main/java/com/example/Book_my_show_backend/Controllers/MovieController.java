package com.example.Book_my_show_backend.Controllers;

import com.example.Book_my_show_backend.Dtos.MovieRequestDto;
import com.example.Book_my_show_backend.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/add")
    public ResponseEntity<String> addMovie(@RequestBody MovieRequestDto movieRequestDto){
        String result= movieService.addMovie(movieRequestDto);
        return  new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
