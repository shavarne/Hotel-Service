package com.project.hotel.controllers;

import com.project.hotel.entities.Hotel;
import com.project.hotel.services.HotelService;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    HotelService hotelService;
    //create
    @PostMapping("/save")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        Hotel hotel1 = hotelService.createHotel(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
    }

    //get single
    @GetMapping("/getsinglehotel/{hotelId}")
    public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId){
        Hotel hotel = hotelService.getHotel(hotelId);

        log.info("Received request to get hotel with ID: {}", hotelId);
        return ResponseEntity.ok(hotel);
    }



    //get all
    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotel(){
        List<Hotel> allHotels = hotelService.getAllHotels();
        return ResponseEntity.status(HttpStatus.FOUND).body(allHotels);
    }

    //delete
    @DeleteMapping("/id")
    public ResponseEntity<String> deleteHotel(@PathVariable String id){
        hotelService.deleteHotel(id);
        return ResponseEntity.ok("Deleted Successfully");
    }
}
