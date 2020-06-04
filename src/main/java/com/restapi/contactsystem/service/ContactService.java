package com.restapi.contactsystem.service;

import com.restapi.contactsystem.entity.Contact;

import java.util.List;

public interface ContactService {
    public List<Contact> findAll();
    public Contact findById(int id);
    public void save(Contact contact);
    public void deleteById(int id);
}
