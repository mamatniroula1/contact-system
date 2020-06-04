package com.restapi.contactsystem.service;

import com.restapi.contactsystem.entity.Contact;
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

        Optional<Contact> contact = contactRepository.findById(id);
        Contact contact1 = null;
        if(contact.isPresent()){
            contact1 = contact.get();
        }else{
            throw new RuntimeException("Did not find Contact Id -" + id);
        }
        return contact1;
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
