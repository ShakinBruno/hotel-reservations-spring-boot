package com.projects.services;

import com.projects.entities.Rooms;
import com.projects.repositories.RoomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoomsServiceImpl implements RoomsService {

    @Autowired
    private RoomsRepository roomsRepository;

    @Override
    public Iterable<Rooms> listAllRooms() {
        return roomsRepository.findAllRooms();
    }

    @Override
    public Optional<Rooms> getRoomById(Integer roomId) {
        return roomsRepository.findRoomById(roomId);
    }

    @Override
    public Iterable<Rooms> listAllRoomsPaging(Integer pageNr, Integer howManyOnPage) {
        return roomsRepository.findAllRooms(pageNr, howManyOnPage);
    }

    @Override
    public void deleteRoom(Integer id) {
        roomsRepository.deleteRoom(id);
    }

    @Override
    public void saveRoom(Rooms room) {
        roomsRepository.addRoom(room);
    }

    @Override
    public void editRoom(Rooms room) {
        roomsRepository.editRoom(room);
    }

    @Override
    public boolean checkIfExist(int id) {
        return roomsRepository.checkIfIdExists(id) > 0;
    }
}
