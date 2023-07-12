package com.projects.repositories;

import com.projects.entities.Hotels;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface HotelsRepository extends CrudRepository<Hotels, Integer>, PagingAndSortingRepository<Hotels, Integer> {

    @Query("SELECT h FROM Hotels h ORDER BY h.id")
    Iterable<Hotels> findAllHotels();

    @Query("SELECT h FROM Hotels h WHERE h.id = ?1")
    Optional<Hotels> findHotelById(Integer id);

    @Query(value = "SELECT * FROM hotels ORDER BY hotel_id OFFSET (?1 - 1) * ?2 LIMIT ?2", nativeQuery = true)
    Iterable<Hotels> findAllHotels(Integer pageNr, Integer howManyOnPage);

    @Query("SELECT COUNT(h) FROM Hotels h WHERE h.id = ?1")
    Integer checkIfIdExists(Integer id);

    @Modifying
    @Transactional
    @Query("DELETE FROM Hotels h WHERE h.id = ?1")
    void deleteHotel(Integer id);

    @Modifying
    @Transactional
    @Query("UPDATE Hotels h SET h.name= :#{#hotel.name}, h.address= :#{#hotel.address}, h.city= :#{#hotel.city} WHERE h.id = :#{#hotel.id}")
    void editHotel(Hotels hotel);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO hotels VALUES (nextval('hotels_hotel_id_seq'), :#{#hotel.name}, :#{#hotel.address}, :#{#hotel.city})", nativeQuery = true)
    void addHotel(Hotels hotel);
}
