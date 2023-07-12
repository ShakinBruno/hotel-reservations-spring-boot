package com.projects.controllers;

import com.projects.entities.Clients;
import com.projects.services.ClientsService;
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
public class ClientsController {

    @Autowired
    private ClientsService clientsService;

    @GetMapping(value = "/clients", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Clients> getClients() {
        return clientsService.listAllClients();
    }

    @GetMapping(value = "/client/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Clients getClientById(@PathVariable("id") Integer id) {
        return clientsService.getClientById(id).orElseGet(null);
    }

    @GetMapping(value = "/client", produces = MediaType.APPLICATION_JSON_VALUE)
    public Clients getClientByParamId(@RequestParam("id") Integer id) {
        return clientsService.getClientById(id).orElseGet(null);
    }

    @GetMapping(value = "/clients/{page}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Clients> getClients(@PathVariable("page") Integer pageNr, @RequestParam("size")Optional<Integer> howManyOnPage) {
        return clientsService.listAllClientsPaging(pageNr, howManyOnPage.orElse(2));
    }

    @DeleteMapping(value = "/client/{id}")
    public ResponseEntity deleteClient(@PathVariable Integer id) {
        clientsService.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/clients/{id}")
    public ResponseEntity deleteBadRequest(@PathVariable Integer id) {
        return new ResponseEntity(HttpStatus.FORBIDDEN);
    }

    @PostMapping(value = "/client")
    public ResponseEntity<Clients> createClient(@RequestBody @NonNull @Valid Clients client) {
        clientsService.saveClient(client);
        return ResponseEntity.ok().body(client);
    }

    @PutMapping(value = "/client")
    public ResponseEntity<Void> editClient(@RequestBody Clients client) {
        if(!clientsService.checkIfExist(client.getId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            clientsService.editClient(client);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }
}
