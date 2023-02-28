package com.example.Book_my_show_backend.Converters;


import com.example.Book_my_show_backend.Dtos.MovieRequestDto;
import com.example.Book_my_show_backend.Models.MovieEntity;

public class MovieConverter {

    public static MovieEntity convertDtoToEntity(MovieRequestDto movieRequestDto){
     MovieEntity movieEntity=MovieEntity.builder().movieDuration(movieRequestDto.getMovieDuration())
             .movieName(movieRequestDto.getMovieName()).releaseDate(movieRequestDto.getReleaseDate()).build();
    return movieEntity;
    }
}
