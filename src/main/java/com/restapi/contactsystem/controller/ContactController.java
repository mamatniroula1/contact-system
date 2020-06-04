package com.restapi.contactsystem.controller;

import com.restapi.contactsystem.entity.Contact;
import com.restapi.contactsystem.repository.ContactRepository;
import com.restapi.contactsystem.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class ContactController {

    private ContactService contactService;

    //controller injection
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/contacts/{id}")
    public Contact getContact(@PathVariable("id") int id) {
        Contact contact = contactService.findById(id);

        if (contact == null){
            throw new RuntimeException("Contact id not found " + id);
        }
        return contact;
    }

    @GetMapping("/contacts")
    public List<Contact> getAlleContacts() {
        return contactService.findAll();
    }

    @PostMapping("/contacts")
    public Contact saveContacts(@RequestBody Contact contact) {
        contact.setId(0);
        contactService.save(contact);
        return contact;
    }

    @PutMapping("/contacts/{id}")
    public Contact updateContacts(@PathVariable("id") int id, @RequestBody Contact contact) {

        Optional<Contact> byId = Optional.ofNullable(contactService.findById(id));
        if (!byId.isPresent()){
            throw new RuntimeException("Contact with " + id + " not found");

        }
        contact.setId(id);
        contactService.save(contact);
        return contact;

    }

    @DeleteMapping("/contacts/{id}")
    public String deleteContact(@PathVariable int id){

        Contact contact = contactService.findById(id);

        if (contact == null){
            throw new RuntimeException("Contact id not found -" + id);
        }

        contactService.deleteById(id);
        return "Deleted contact id is -> " + id;
    }
}
