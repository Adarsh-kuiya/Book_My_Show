package com.example.Book_my_show_backend.Models;


import com.example.Book_my_show_backend.Enums.SeatType;
import javax.persistence.*;
import lombok.*;

//It represent physical seats or the actual seat
@Entity
@Table(name = "theater_seats")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TheaterSeatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;



    String seatNo;


   @Enumerated(value=EnumType.STRING)
    private SeatType seatType;

    private  int rate;

    public TheaterSeatEntity(String seatNo, SeatType seatType, int rate) {
        this.seatNo = seatNo;
        this.seatType = seatType;
        this.rate = rate;
    }

    @ManyToOne
    @JoinColumn
    private TheaterEntity theater;



}
