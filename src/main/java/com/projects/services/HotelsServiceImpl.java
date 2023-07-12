package com.projects.services;

import com.projects.entities.Hotels;
import com.projects.repositories.HotelsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HotelsServiceImpl implements HotelsService {

    @Autowired
    private HotelsRepository hotelsRepository;

    @Override
    public Iterable<Hotels> listAllHotels() {
        return hotelsRepository.findAllHotels();
    }

    @Override
    public Optional<Hotels> getHotelById(Integer hotelId) {
        return hotelsRepository.findHotelById(hotelId);
    }

    @Override
    public Iterable<Hotels> listAllHotelsPaging(Integer pageNr, Integer howManyOnPage) {
        return hotelsRepository.findAllHotels(pageNr, howManyOnPage);
    }

    @Override
    public void deleteHotel(Integer id) {
        hotelsRepository.deleteHotel(id);
    }

    @Override
    public void saveHotel(Hotels hotel) {
        hotelsRepository.addHotel(hotel);
    }

    @Override
    public void editHotel(Hotels hotel) {
        hotelsRepository.editHotel(hotel);
    }

    @Override
    public boolean checkIfExist(int id) {
        return hotelsRepository.checkIfIdExists(id) > 0;
    }
}
