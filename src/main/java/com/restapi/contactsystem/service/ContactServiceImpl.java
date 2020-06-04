package com.restapi.contactsystem.service;

import com.restapi.contactsystem.entity.Contact;
import com.restapi.contactsystem.exceptions.ResourceNotFoundException;
import com.restapi.contactsystem.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService{

    private ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    @Override
    public Contact findById(int id) {

        Contact contact = contactRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Contact not found with id -> " + id));
        return contact;
    }

    @Override
    public void save(Contact contact) {
        contactRepository.save(contact);

    }

    @Override
    public void deleteById(int id) {
        contactRepository.deleteById(id);

    }
}
