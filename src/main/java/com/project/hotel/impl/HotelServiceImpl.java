package com.project.hotel.impl;

import com.project.hotel.entities.Hotel;
import com.project.hotel.exceptions.ResourceNotFoundException;
import com.project.hotel.repository.HotelRepository;
import com.project.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelRepository hotelRepository;

    @Override
    public Hotel createHotel(Hotel hotel) {

        String randomHotelId = UUID.randomUUID().toString();
        hotel.setId(randomHotelId);
       Optional<Hotel> hotel1 = hotelRepository.findByNameAndLocation(hotel.getName(),hotel.getLocation());

       if(hotel1.isPresent()){
           Hotel existing = hotel1.get();
           hotel.setId(existing.getId());
       }
       return hotelRepository.save(hotel);
    }



    @Override
    public List<Hotel> getAllHotels() {
        List<Hotel> hotels = hotelRepository.findAll();
        return hotels;
    }

    @Override
    public Hotel getHotel(String id) {
        return hotelRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("hotel with given id not found"));
    }

    @Override
    public void deleteHotel(String id) {

    }
}
