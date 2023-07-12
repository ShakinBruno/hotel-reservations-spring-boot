package com.projects.services;

import com.projects.entities.Rooms;

import java.util.Optional;

public interface RoomsService {

    Iterable<Rooms> listAllRooms();

    Optional<Rooms> getRoomById(Integer roomId);

    Iterable<Rooms> listAllRoomsPaging(Integer pageNr, Integer howManyOnPage);

    void deleteRoom(Integer id);

    void saveRoom(Rooms room);

    void editRoom(Rooms room);

    boolean checkIfExist(int id);
}
