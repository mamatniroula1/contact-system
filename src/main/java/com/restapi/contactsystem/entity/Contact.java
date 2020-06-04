package com.restapi.contactsystem.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade= CascadeType.ALL)
    private Name name;

    @OneToOne(cascade=CascadeType.ALL)
    private Address address;

    @OneToMany(cascade=CascadeType.ALL)
    private Set<Phone> phone;

    private String email;
}
