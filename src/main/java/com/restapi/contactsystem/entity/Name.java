package com.restapi.contactsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Name {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String first;
    private String last;
    private String middle;


    @JsonIgnore
    @OneToOne(mappedBy="name", cascade= CascadeType.ALL)
    private Contact contact;
}
