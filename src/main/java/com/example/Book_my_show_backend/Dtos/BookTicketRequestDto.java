package com.example.Book_my_show_backend.Dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class BookTicketRequestDto {
    private List<String>  requestedSeats;

    private  int showId;

    private int userId;

}


/*Book ticket request Dto
step 1: user send request book tickets
step 2: In show seats entity we will check whether selected seats by user are available or not

for(i=0 ->i<show show seats){
if(booked_ticket->false) book the ticket
}
step 3: calculate the amount , change the status of show_seats from not booked to booked and map the ticket

for(booked seats ){
booked seats
}
ticket entity = new ticket entity

ticket entity set user
ticket entity set show

After that final step is bidirectional mapping  to save all the thing to repository
 */