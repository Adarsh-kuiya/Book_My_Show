package com.example.Book_my_show_backend.Converters;

import com.example.Book_my_show_backend.Dtos.ShowRequestDto;
import com.example.Book_my_show_backend.Models.MovieEntity;
import com.example.Book_my_show_backend.Models.ShowEntity;
import com.example.Book_my_show_backend.Models.TheaterEntity;
import com.example.Book_my_show_backend.Repository.MovieRepository;
import com.example.Book_my_show_backend.Repository.ShowRepository;
import com.example.Book_my_show_backend.Repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;

public  class ShowConverter {


    public static  ShowEntity convertDtoToEntity(ShowRequestDto showRequestDto){

        ShowEntity showEntity=ShowEntity.builder().showDate(showRequestDto.getShowDate())
                .showTime(showRequestDto.getShowTime()).multiplier(showRequestDto.getMultiplier()
                )
                .build();

        return showEntity;


    }
}
