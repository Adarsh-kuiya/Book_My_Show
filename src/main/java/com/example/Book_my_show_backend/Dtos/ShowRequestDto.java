package com.example.Book_my_show_backend.Dtos;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
public class ShowRequestDto {


     private LocalDate showDate;

     private LocalTime showTime;

     private String movieName;

     private  double multiplier;

     private  int theaterId;

}
