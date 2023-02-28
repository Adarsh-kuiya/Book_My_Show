package com.example.Book_my_show_backend.Converters;


import com.example.Book_my_show_backend.Dtos.TheaterRequestDto;
import com.example.Book_my_show_backend.Models.TheaterEntity;

public class TheaterConverter {

    public static TheaterEntity convertDtoToEntity(TheaterRequestDto theaterRequestDto){
       TheaterEntity theaterEntity = TheaterEntity.builder().name(theaterRequestDto.getName())
               .city(theaterRequestDto.getCity()).address(theaterRequestDto.getAddress())
               .build();
     return theaterEntity;}
}
