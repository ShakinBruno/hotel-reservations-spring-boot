package com.projects.services;

import com.projects.entities.Reservations;

import java.util.Optional;

public interface ReservationsService {

    Iterable<Reservations> listAllReservations();

    Optional<Reservations> getReservationById(Integer reservationId);

    Iterable<Reservations> listAllReservationsPaging(Integer pageNr, Integer howManyOnPage);

    void deleteReservation(Integer id);

    void saveReservation(Reservations reservation);

    void editReservation(Reservations reservation);

    boolean checkIfExist(int id);
}
