package com.projects.repositories;

import com.projects.entities.Clients;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface ClientsRepository extends CrudRepository<Clients, Integer>, PagingAndSortingRepository<Clients, Integer> {

    @Query("SELECT c FROM Clients c ORDER BY c.id")
    Iterable<Clients> findAllClients();

    @Query("SELECT c FROM Clients c WHERE c.id = ?1")
    Optional<Clients> findClientById(Integer id);

    @Query(value = "SELECT * FROM clients ORDER BY client_id OFFSET (?1 - 1) * ?2 LIMIT ?2", nativeQuery = true)
    Iterable<Clients> findAllClients(Integer pageNr, Integer howManyOnPage);

    @Query("SELECT COUNT(c) FROM Clients c WHERE c.id = ?1")
    Integer checkIfIdExists(Integer id);

    @Modifying
    @Transactional
    @Query("DELETE FROM Clients c WHERE c.id = ?1")
    void deleteClient(Integer id);

    @Modifying
    @Transactional
    @Query("UPDATE Clients c SET c.firstName= :#{#client.firstName}, c.lastName= :#{#client.lastName},c.address= :#{#client.address}, c.city= :#{#client.city} WHERE c.id = :#{#client.id}")
    void editClient(Clients client);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO clients VALUES (nextval('clients_client_id_seq'), :#{#client.firstName}, :#{#client.lastName}, :#{#client.address}, :#{#client.city})", nativeQuery = true)
    void addClient(Clients client);
}
