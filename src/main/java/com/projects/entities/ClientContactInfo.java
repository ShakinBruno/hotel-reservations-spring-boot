package com.projects.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Objects;

@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class,
        property="refClientContactInfoId", scope=ClientContactInfo.class)
@Table(name = "client_contact_info", schema = "public", catalog = "Project")
public class ClientContactInfo {
    private String telephone;
    private String email;
    private int id;

    @Basic
    @Column(name = "client_telephone")
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Basic
    @Column(name = "client_email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Id
    @Column(name = "client_client_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ClientContactInfo{" +
                "clientContactInfoTelephone='" + telephone + '\'' +
                ", clientContactInfoEmail='" + email + '\'' +
                ", clientContactInfoId=" + id +
                '}';
    }
}
