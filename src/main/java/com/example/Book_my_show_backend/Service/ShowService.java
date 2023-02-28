package com.example.Book_my_show_backend.Service;

import com.example.Book_my_show_backend.Converters.ShowConverter;
import com.example.Book_my_show_backend.Dtos.ShowRequestDto;
import com.example.Book_my_show_backend.Models.*;
import com.example.Book_my_show_backend.Repository.MovieRepository;
import com.example.Book_my_show_backend.Repository.ShowRepository;
import com.example.Book_my_show_backend.Repository.ShowSeatRepository;
import com.example.Book_my_show_backend.Repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {
    @Autowired
    ShowRepository showRepository;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    TheaterRepository theaterRepository;
    @Autowired
    ShowSeatRepository showSeatRepository;


    public String addShow(ShowRequestDto showRequestDto){
    // converting   Dto to Entity

        ShowEntity showEntity=ShowConverter.convertDtoToEntity(showRequestDto);
        MovieEntity movieEntity= movieRepository.findByMovieName(showRequestDto.getMovieName());
        TheaterEntity theaterEntity= theaterRepository.findById(showRequestDto.getTheaterId()).get();
        showEntity.setMovie(movieEntity);
        showEntity.setTheater(theaterEntity);

        List<ShowSeatEntity> seatEntityList= createShowSeats(theaterEntity.getTheaterSeatEntityList());

        showEntity.setListOfSeats(seatEntityList);

        for(ShowSeatEntity showSeat:seatEntityList){

            //for each show seat we have to mark to which show it belongs(this behaves as a FK in show seat entity table
         showSeat.setShow(showEntity);

        }
        movieRepository.save(movieEntity);
        theaterRepository.save(theaterEntity);
        // both the above are parent entity of show entity  and as they are called show entity saves automatically and
        // duplicate area not formed because when second entity is called is just updates the first entity
        showRepository.save(showEntity);
        return "Show is added successfully";
    }


    public  List<ShowSeatEntity> createShowSeats(List<TheaterSeatEntity> theaterSeatEntityList){

    List<ShowSeatEntity> seats= new ArrayList<>();

    for(TheaterSeatEntity theaterSeat:theaterSeatEntityList){

        ShowSeatEntity showSeat=ShowSeatEntity.builder().seatNo(theaterSeat.getSeatNo())
                .seatType(theaterSeat.getSeatType()). build();
    seats.add(showSeat);
    }
//   showSeatRepository.saveAll(seats);
    return  seats;

    }

}
