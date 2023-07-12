package com.projects.repositories;

import com.projects.entities.Rooms;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface RoomsRepository extends CrudRepository<Rooms, Integer>, PagingAndSortingRepository<Rooms, Integer> {

    @Query("SELECT r FROM Rooms r ORDER BY r.id")
    Iterable<Rooms> findAllRooms();

    @Query("SELECT r FROM Rooms r WHERE r.id = ?1")
    Optional<Rooms> findRoomById(Integer roomId);

    @Query(value = "SELECT * FROM rooms ORDER BY room_id OFFSET (?1 - 1) * ?2 LIMIT ?2", nativeQuery = true)
    Iterable<Rooms> findAllRooms(Integer pageNr, Integer howManyOnPage);

    @Query("SELECT COUNT(r) FROM Rooms r WHERE r.id = ?1")
    Integer checkIfIdExists(Integer id);

    @Modifying
    @Transactional
    @Query("DELETE FROM Rooms r WHERE r.id = ?1")
    void deleteRoom(Integer id);

    @Modifying
    @Transactional
    @Query("UPDATE Rooms r SET r.number= :#{#room.number}, r.people= :#{#room.people} WHERE r.id = :#{#room.id}")
    void editRoom(Rooms room);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO rooms VALUES (nextval('rooms_room_id_seq'), null, :#{#room.number}, :#{#room.people})", nativeQuery = true)
    void addRoom(Rooms room);
}
