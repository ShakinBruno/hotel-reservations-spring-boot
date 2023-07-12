package com.projects.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class,
        property="refRoomId", scope=Rooms.class)
@Table(name = "rooms", schema = "public", catalog = "Project")
public class Rooms {
    private int id;
    private Integer number;
    private Integer people;
    private Hotels hotelsByRoomHotelId;
    private Set<Reservations> reservationsByRoomId = new HashSet<>();

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "room_number")
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Basic
    @Column(name = "room_people")
    public Integer getPeople() {
        return people;
    }

    public void setPeople(Integer people) {
        this.people = people;
    }

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "room_hotel_id", referencedColumnName = "hotel_id")
    public Hotels getHotelsByRoomHotelId() {
        return hotelsByRoomHotelId;
    }

    public void setHotelsByRoomHotelId(Hotels hotelsByRoomHotelId) {
        this.hotelsByRoomHotelId = hotelsByRoomHotelId;
    }

    @OneToMany(mappedBy = "roomsByReservationRoomId")
    @JsonIgnore
    public Set<Reservations> getReservationsByRoomId() {
        return reservationsByRoomId;
    }

    public void setReservationsByRoomId(Set<Reservations> reservationsByRoomId) {
        this.reservationsByRoomId = reservationsByRoomId;
    }

    @Override
    public String toString() {
        return "Rooms{" +
                "id=" + id +
                ", number=" + number +
                ", people=" + people +
                '}';
    }
}
