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
        property="refHotelId", scope=Hotels.class)
@Table(name = "hotels", schema = "public", catalog = "Project")
public class Hotels {
    private int id;
    private String name;
    private String address;
    private String city;
    private HotelContactInfo contactInfoByHotelId;
    private Set<Rooms> roomsByHotelId = new HashSet<>();

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "hotel_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "hotel_address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "hotel_city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hotel_id", referencedColumnName = "hotel_hotel_id", nullable = false)
    public HotelContactInfo getContactInfoByHotelId() {
        return contactInfoByHotelId;
    }

    public void setContactInfoByHotelId(HotelContactInfo contactInfoByHotelId) {
        this.contactInfoByHotelId = contactInfoByHotelId;
    }

    @OneToMany(mappedBy = "hotelsByRoomHotelId", fetch = FetchType.EAGER)
    @JsonIgnore
    public Set<Rooms> getRoomsByHotelId(){
        return roomsByHotelId;
    }

    public void setRoomsByHotelId(Set<Rooms> roomsByHotelId) {
        this.roomsByHotelId = roomsByHotelId;
    }

    @Override
    public String toString() {
        return "Hotels{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
