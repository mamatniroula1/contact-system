package com.restapi.contactsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Address {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String street;
    private String city;
    private String state;
    private int zip;


    @JsonIgnore
    @OneToOne(mappedBy="address", cascade= CascadeType.ALL)
    private Contact contact;
}
