package com.projects.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Objects;

@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class,
        property="refHotelContactInfoId", scope=HotelContactInfo.class)
@Table(name = "hotel_contact_info", schema = "public", catalog = "Project")
public class HotelContactInfo {
    private String telephone;
    private String email;
    private String www;
    private int hotelContactInfoId;

    @Basic
    @Column(name = "hotel_telephone")
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Basic
    @Column(name = "hotel_email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "hotel_www")
    public String getWww() {
        return www;
    }

    public void setWww(String www) {
        this.www = www;
    }

    @Id
    @Column(name = "hotel_hotel_id")
    public int getHotelContactInfoId() {
        return hotelContactInfoId;
    }

    public void setHotelContactInfoId(int hotelContactInfoId) {
        this.hotelContactInfoId = hotelContactInfoId;
    }

    @Override
    public String toString() {
        return "HotelContactInfo{" +
                "hotelTelephone='" + telephone + '\'' +
                ", hotelEmail='" + email + '\'' +
                ", hotelWww='" + www + '\'' +
                ", hotelContactInfoId=" + hotelContactInfoId +
                '}';
    }
}
