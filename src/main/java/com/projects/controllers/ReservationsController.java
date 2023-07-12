package com.projects.controllers;

import com.projects.entities.Reservations;
import com.projects.services.ReservationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin
public class ReservationsController {

    @Autowired
    private ReservationsService reservationsService;

    @GetMapping(value = "/reservations", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Reservations> getReservations() {
        return reservationsService.listAllReservations();
    }

    @GetMapping(value = "/reservation/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reservations getReservationById(@PathVariable("id") Integer id) {
        return reservationsService.getReservationById(id).orElseGet(null);
    }

    @GetMapping(value = "/reservation", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reservations getReservationByParamId(@RequestParam("id") Integer id) {
        return reservationsService.getReservationById(id).orElseGet(null);
    }

    @GetMapping(value = "/reservations/{page}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Reservations> getReservations(@PathVariable("page") Integer pageNr, @RequestParam("size") Optional<Integer> howManyOnPage) {
        return reservationsService.listAllReservationsPaging(pageNr, howManyOnPage.orElse(2));
    }

    @DeleteMapping(value = "/reservation/{id}")
    public ResponseEntity deleteClient(@PathVariable Integer id) {
        reservationsService.deleteReservation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/reservations/{id}")
    public ResponseEntity deleteBadRequest(@PathVariable Integer id) {
        return new ResponseEntity(HttpStatus.FORBIDDEN);
    }

    @PostMapping(value = "/reservation")
    public ResponseEntity<Reservations> createReservation(@RequestBody @NonNull @Valid Reservations reservation) {
        reservationsService.saveReservation(reservation);
        return ResponseEntity.ok().body(reservation);
    }

    @PutMapping(value = "/reservation")
    public ResponseEntity<Void> editReservation(@RequestBody Reservations reservation) {
        if(!reservationsService.checkIfExist(reservation.getId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            reservationsService.editReservation(reservation);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }
}
