package com.example.Book_my_show_backend.Dtos;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class MovieRequestDto {

    private int movieDuration;

    private String movieName;

    private Date releaseDate;
}
