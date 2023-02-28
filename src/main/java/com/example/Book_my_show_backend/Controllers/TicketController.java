package com.example.Book_my_show_backend.Controllers;

import com.example.Book_my_show_backend.Dtos.BookTicketRequestDto;
import com.example.Book_my_show_backend.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    TicketService ticketService;

  @PostMapping("/book")
   public ResponseEntity<String> bookTicket(@RequestBody BookTicketRequestDto bookTicketRequestDto) {
      String result= null;
      try {
          result = ticketService.bookTicket(bookTicketRequestDto);
      } catch (Exception e) {
          return new ResponseEntity<>("seats are already booked",HttpStatus.INTERNAL_SERVER_ERROR);
      }
      return new ResponseEntity<>(result,HttpStatus.CREATED);
  }
}
