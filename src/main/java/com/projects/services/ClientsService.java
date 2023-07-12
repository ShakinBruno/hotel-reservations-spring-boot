package com.projects.services;

import com.projects.entities.Clients;

import java.util.Optional;

public interface ClientsService {

    Iterable<Clients> listAllClients();

    Optional<Clients> getClientById(Integer id);

    Iterable<Clients> listAllClientsPaging(Integer pageNr, Integer howManyOnPage);

    void deleteClient(Integer id);

    void saveClient(Clients client);

    void editClient(Clients client);

    boolean checkIfExist(int id);
}
