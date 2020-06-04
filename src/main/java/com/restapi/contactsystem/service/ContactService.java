package com.restapi.contactsystem.service;

import com.restapi.contactsystem.entity.Contact;

import java.util.List;

public interface ContactService {
     List<Contact> findAll();
     Contact findById(int id);
     void save(Contact contact);
     void deleteById(int id);
}
