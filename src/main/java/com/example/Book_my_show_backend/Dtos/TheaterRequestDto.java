package com.example.Book_my_show_backend.Dtos;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TheaterRequestDto {


    private String name;

    private String city;

    private String address;
}
