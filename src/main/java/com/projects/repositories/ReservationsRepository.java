package com.projects.repositories;

import com.projects.entities.Reservations;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface ReservationsRepository extends CrudRepository<Reservations, Integer>, PagingAndSortingRepository<Reservations, Integer> {

    @Query("SELECT r FROM Reservations r ORDER BY r.id")
    Iterable<Reservations> findAllReservations();

    @Query("SELECT r FROM Reservations r WHERE r.id = ?1")
    Optional<Reservations> findReservationById(Integer reservationId);

    @Query(value = "SELECT * FROM reservations ORDER BY reservation_id OFFSET (?1 - 1) * ?2 LIMIT ?2", nativeQuery = true)
    Iterable<Reservations> findAllReservations(Integer pageNr, Integer howManyOnPage);

    @Query("SELECT COUNT(r) FROM Reservations r WHERE r.id = ?1")
    Integer checkIfIdExists(Integer id);

    @Modifying
    @Transactional
    @Query("DELETE FROM Reservations r WHERE r.id = ?1")
    void deleteReservation(Integer id);

    @Modifying
    @Transactional
    @Query("UPDATE Reservations r SET r.startingDate= :#{#reservation.startingDate}, r.finalDate= :#{#reservation.finalDate} WHERE r.id = :#{#reservation.id}")
    void editReservation(Reservations reservation);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO reservations VALUES (nextval('reservations_reservation_id_seq'), null, :#{#reservation.startingDate}, :#{#reservation.finalDate}, null)", nativeQuery = true)
    void addReservation(Reservations reservation);
}
