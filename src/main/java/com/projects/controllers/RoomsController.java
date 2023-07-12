package com.projects.controllers;

import com.projects.entities.Rooms;
import com.projects.services.RoomsService;
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
public class RoomsController {

    @Autowired
    private RoomsService roomsService;

    @GetMapping(value = "/rooms", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Rooms> getRooms() {
        return roomsService.listAllRooms();
    }

    @GetMapping(value = "/room/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Rooms getRoomById(@PathVariable("id") Integer id) {
        return roomsService.getRoomById(id).orElseGet(null);
    }

    @GetMapping(value = "/room", produces = MediaType.APPLICATION_JSON_VALUE)
    public Rooms getRoomByParamId(@RequestParam("id") Integer id) {
        return roomsService.getRoomById(id).orElseGet(null);
    }

    @GetMapping(value = "/rooms/{page}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Rooms> getRooms(@PathVariable("page") Integer pageNr, @RequestParam("size") Optional<Integer> howManyOnPage) {
        return roomsService.listAllRoomsPaging(pageNr, howManyOnPage.orElse(2));
    }

    @DeleteMapping(value = "/room/{id}")
    public ResponseEntity deleteRoom(@PathVariable Integer id) {
        roomsService.deleteRoom(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/rooms/{id}")
    public ResponseEntity deleteBadRequest(@PathVariable Integer id) {
        return new ResponseEntity(HttpStatus.FORBIDDEN);
    }

    @PostMapping(value = "/room")
    public ResponseEntity<Rooms> createRoom(@RequestBody @NonNull @Valid Rooms room) {
        roomsService.saveRoom(room);
        return ResponseEntity.ok().body(room);
    }

    @PutMapping(value = "/room")
    public ResponseEntity<Void> editRoom(@RequestBody Rooms room) {
        if(!roomsService.checkIfExist(room.getId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            roomsService.editRoom(room);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }
}
