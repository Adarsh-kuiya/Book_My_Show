package com.example.Book_my_show_backend.Dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRequestDto {
    private String name;
    private int mobile;
}
