package com.projects.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Date;

@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class,
        property="refReservationId", scope=Reservations.class)
@Table(name = "reservations", schema = "public", catalog = "Project")
public class Reservations {
    private int id;
    private Date startingDate;
    private Date finalDate;
    private Clients clientsByReservationClientId;
    private Rooms roomsByReservationRoomId;

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(name = "reservation_starting_date", length = 1000)
    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    @Basic
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(name = "reservation_final_date", length = 1000)
    public Date getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "reservation_client_id", referencedColumnName = "client_id")
    public Clients getClientsByReservationClientId() {
        return clientsByReservationClientId;
    }

    public void setClientsByReservationClientId(Clients clientsByReservationClientId) {
        this.clientsByReservationClientId = clientsByReservationClientId;
    }

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "reservation_room_id", referencedColumnName = "room_id")
    public Rooms getRoomsByReservationRoomId() { return roomsByReservationRoomId; }

    public void setRoomsByReservationRoomId(Rooms roomsByReservationRoomId) {
        this.roomsByReservationRoomId = roomsByReservationRoomId;
    }

    @Override
    public String toString() {
        return "Reservations{" +
                "id=" + id +
                ", startingDate=" + startingDate +
                ", finalDate=" + finalDate +
                '}';
    }
}
