package com.example.Book_my_show_backend.Service;


import com.example.Book_my_show_backend.Converters.MovieConverter;
import com.example.Book_my_show_backend.Dtos.MovieRequestDto;
import com.example.Book_my_show_backend.Models.MovieEntity;
import com.example.Book_my_show_backend.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String addMovie(MovieRequestDto movieRequestDto){

        MovieEntity movieEntity= MovieConverter.convertDtoToEntity(movieRequestDto);

        try {
            movieRepository.save(movieEntity);
        }
        catch (Exception e){
         return "movie could not be added";
        }
    return "movie added successfully";
    }


}
