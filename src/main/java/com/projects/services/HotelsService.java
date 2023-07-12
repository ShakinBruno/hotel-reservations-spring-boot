package com.projects.services;

import com.projects.entities.Clients;
import com.projects.entities.Hotels;

import java.util.Optional;

public interface HotelsService {

    Iterable<Hotels> listAllHotels();

    Optional<Hotels> getHotelById(Integer id);

    Iterable<Hotels> listAllHotelsPaging(Integer pageNr, Integer howManyOnPage);

    void deleteHotel(Integer id);

    void saveHotel(Hotels hotel);

    void editHotel(Hotels hotel);

    boolean checkIfExist(int id);
}
