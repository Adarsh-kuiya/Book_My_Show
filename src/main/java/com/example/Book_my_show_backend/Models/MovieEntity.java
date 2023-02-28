package com.example.Book_my_show_backend.Models;


import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "movies")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int movieDuration;

    private Date releaseDate;

    @Column(nullable = false,unique = true)
    private String movieName;

    @OneToMany(mappedBy = "movie",cascade = CascadeType.ALL)
    private List<ShowEntity>listOfShows;
}
