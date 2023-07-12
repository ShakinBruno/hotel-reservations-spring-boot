package com.projects.services;

import com.projects.entities.Clients;
import com.projects.repositories.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientsServiceImpl implements ClientsService {

    @Autowired
    private ClientsRepository clientsRepository;

    @Override
    public Iterable<Clients> listAllClients() {
        return clientsRepository.findAllClients();
    }

    @Override
    public Optional<Clients> getClientById(Integer id) {
        return clientsRepository.findClientById(id);
    }

    @Override
    public Iterable<Clients> listAllClientsPaging(Integer pageNr, Integer howManyOnPage) {
        return clientsRepository.findAllClients(pageNr, howManyOnPage);
    }

    @Override
    public void deleteClient(Integer id) {
        clientsRepository.deleteClient(id);
    }

    @Override
    public void saveClient(Clients client) {
        clientsRepository.addClient(client);
    }

    @Override
    public void editClient(Clients client) {
        clientsRepository.editClient(client);
    }

    @Override
    public boolean checkIfExist(int id) {
        return clientsRepository.checkIfIdExists(id) > 0;
    }
}
