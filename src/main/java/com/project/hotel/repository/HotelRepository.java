package com.project.hotel.repository;

import com.project.hotel.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,String> {

    Optional<Hotel> findByNameAndLocation(String name, String location);
}
