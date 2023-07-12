package com.projects.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class,
        property="refClientId", scope=Clients.class)
@Table(name = "clients", schema = "public", catalog = "Project")
public class Clients {
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private ClientContactInfo contactInfoByClientId;
    private Set<Reservations> reservationsByClientId = new HashSet<>();

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    public int getId() {
        return id;
    }

    public void setId(int clientId) {
        this.id = clientId;
    }

    @Basic
    @Column(name = "client_first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "client_last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "client_address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "client_city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", referencedColumnName = "client_client_id", nullable = false)
    public ClientContactInfo getContactInfoByClientId() {
        return contactInfoByClientId;
    }

    public void setContactInfoByClientId(ClientContactInfo contactInfoByClientId) {
        this.contactInfoByClientId = contactInfoByClientId;
    }

    @OneToMany(mappedBy = "clientsByReservationClientId", fetch = FetchType.EAGER)
    @JsonIgnore
    public Set<Reservations> getReservationsByClientId() {
        return reservationsByClientId;
    }

    public void setReservationsByClientId(Set<Reservations> reservationsByClientId) {
        this.reservationsByClientId = reservationsByClientId;
    }

    @Override
    public String toString() {
        return "Clients{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
