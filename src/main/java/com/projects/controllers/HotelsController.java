package com.projects.controllers;

import com.projects.entities.Hotels;
import com.projects.services.HotelsService;
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
public class HotelsController {

    @Autowired
    private HotelsService hotelsService;

    @GetMapping(value = "/hotels", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Hotels> getHotels() {
        return hotelsService.listAllHotels();
    }

    @GetMapping(value = "/hotel/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Hotels getHotelById(@PathVariable("id") Integer id) {
        return hotelsService.getHotelById(id).orElseGet(null);
    }

    @GetMapping(value = "/hotel", produces = MediaType.APPLICATION_JSON_VALUE)
    public Hotels getHotelByParamId(@RequestParam("id") Integer id) {
        return hotelsService.getHotelById(id).orElseGet(null);
    }

    @GetMapping(value = "/hotels/{page}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Hotels> getHotels(@PathVariable("page") Integer pageNr, @RequestParam("size") Optional<Integer> howManyOnPage) {
        return hotelsService.listAllHotelsPaging(pageNr, howManyOnPage.orElse(2));
    }

    @DeleteMapping(value = "/hotel/{id}")
    public ResponseEntity deleteHotel(@PathVariable Integer id) {
        hotelsService.deleteHotel(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/hotels/{id}")
    public ResponseEntity deleteBadRequest(@PathVariable Integer id) {
        return new ResponseEntity(HttpStatus.FORBIDDEN);
    }

    @PostMapping(value = "/hotel")
    public ResponseEntity<Hotels> createHotel(@RequestBody @NonNull @Valid Hotels hotel) {
        hotelsService.saveHotel(hotel);
        return ResponseEntity.ok().body(hotel);
    }

    @PutMapping(value = "/hotel")
    public ResponseEntity<Void> editHotel(@RequestBody Hotels hotel) {
        if(!hotelsService.checkIfExist(hotel.getId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            hotelsService.editHotel(hotel);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }
}
