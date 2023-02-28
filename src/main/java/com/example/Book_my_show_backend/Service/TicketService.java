package com.example.Book_my_show_backend.Service;


import com.example.Book_my_show_backend.Dtos.BookTicketRequestDto;
import com.example.Book_my_show_backend.Models.ShowEntity;
import com.example.Book_my_show_backend.Models.ShowSeatEntity;
import com.example.Book_my_show_backend.Models.TicketEntity;
import com.example.Book_my_show_backend.Models.UserEntity;
import com.example.Book_my_show_backend.Repository.ShowRepository;
import com.example.Book_my_show_backend.Repository.TicketRepository;
import com.example.Book_my_show_backend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TicketService {

 @Autowired
    ShowRepository showRepository;
 @Autowired
    UserRepository userRepository;
 @Autowired
    TicketRepository ticketRepository;

 public String bookTicket(BookTicketRequestDto bookTicketRequestDto) throws Exception {

    //get the request
    List<String> requestedSeats=bookTicketRequestDto.getRequestedSeats();

    ShowEntity showEntity= showRepository.findById(bookTicketRequestDto.getShowId()).get();

    UserEntity userEntity=userRepository.findById(bookTicketRequestDto.getUserId()).get();

    //get the show seats from show Entity

     List<ShowSeatEntity> showSeats= showEntity.getListOfSeats();

     //validate if I can allocate these seats or not to requested user
     List<ShowSeatEntity> bookedSeats=new ArrayList<>();

     for(ShowSeatEntity showSeat:showSeats){

      String seatNo= showSeat.getSeatNo();

      if(showSeat.isBooked()==false&& requestedSeats.contains(seatNo)){
       bookedSeats.add(showSeat);
         }
     }

     if(bookedSeats.size()!=requestedSeats.size()){
         //some or all seats may be not available
         throw new Exception(" Requested seats are not available");
     }

    //it means booked seats contain the seats requested by user so now ew calculate the amount of ticket,booked status

     TicketEntity ticketEntity = new TicketEntity();

     double totalAmount=0;
     double multiplier=showEntity.getMultiplier();

     String allottedSeats="";

     int rate =0;
     for(ShowSeatEntity bookSeat:bookedSeats){
        bookSeat.setBooked(true);
        bookSeat.setBookedAt(new Date());
        bookSeat.setTicket(ticketEntity);
        bookSeat.setShow(showEntity);

        String seatNo=bookSeat.getSeatNo();
        allottedSeats=allottedSeats+seatNo+",";
        if (seatNo.charAt(0)=='1')
           rate=100;
        else rate=200;

        totalAmount=totalAmount+ multiplier*rate;
     }

     ticketEntity.setBooked_at( new Date());
     ticketEntity.setShow(showEntity);
     ticketEntity.setAmount((int) totalAmount);
     ticketEntity.setBookedSeats(bookedSeats);
     ticketEntity.setUser(userEntity);
     ticketEntity.setAlloted_seats(allottedSeats);

     ticketRepository.save(ticketEntity);

     return "ticket is booked successfully";
 }

}
