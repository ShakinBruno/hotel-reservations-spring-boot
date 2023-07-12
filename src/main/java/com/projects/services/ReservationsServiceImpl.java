package com.projects.services;

import com.projects.entities.Reservations;
import com.projects.repositories.ReservationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationsServiceImpl implements ReservationsService {

    @Autowired
    private ReservationsRepository reservationsRepository;

    @Override
    public Iterable<Reservations> listAllReservations() {
        return reservationsRepository.findAllReservations();
    }

    @Override
    public Optional<Reservations> getReservationById(Integer reservationId) {
        return reservationsRepository.findReservationById(reservationId);
    }

    @Override
    public Iterable<Reservations> listAllReservationsPaging(Integer pageNr, Integer howManyOnPage) {
        return reservationsRepository.findAllReservations(pageNr, howManyOnPage);
    }

    @Override
    public void deleteReservation(Integer id) {
        reservationsRepository.deleteReservation(id);
    }

    @Override
    public void saveReservation(Reservations reservation) {
        reservationsRepository.addReservation(reservation);
    }

    @Override
    public void editReservation(Reservations reservation) {
        reservationsRepository.editReservation(reservation);
    }

    @Override
    public boolean checkIfExist(int id) {
        return reservationsRepository.checkIfIdExists(id) > 0;
    }
}
