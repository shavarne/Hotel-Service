package com.project.hotel.services;

import com.project.hotel.entities.Hotel;

import java.util.List;

public interface HotelService {

    //create
    Hotel createHotel(Hotel hotel);

    //getAll
    List<Hotel> getAllHotels();

    //getSingle
    Hotel getHotel(String id);

    //deleteById
    void deleteHotel(String id);
}
