package com.example.Book_my_show_backend.Models;


import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "theater")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TheaterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String city;

    private String address;

    //List of shows

   @OneToMany(mappedBy = "theater",cascade = CascadeType.ALL)
   List<ShowEntity>listOfShows;

    //list of theater seat
    @OneToMany(mappedBy = "theater",cascade = CascadeType.ALL)
    List<TheaterSeatEntity>theaterSeatEntityList;

}
