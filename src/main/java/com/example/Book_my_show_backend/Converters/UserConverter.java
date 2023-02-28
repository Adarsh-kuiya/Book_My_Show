package com.example.Book_my_show_backend.Converters;

import com.example.Book_my_show_backend.Dtos.UserRequestDto;
import com.example.Book_my_show_backend.Models.UserEntity;

public class UserConverter {

    public static UserEntity convertDtoEntity(UserRequestDto userRequestDto){

        UserEntity userEntity= UserEntity.builder().name(userRequestDto.getName()).mobile(userRequestDto.getMobile()).build();

        return userEntity;
    }
}
