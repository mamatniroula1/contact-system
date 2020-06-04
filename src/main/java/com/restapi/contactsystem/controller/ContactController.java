package com.restapi.contactsystem.controller;

import com.restapi.contactsystem.entity.Contact;
import com.restapi.contactsystem.exceptions.ResourceNotFoundException;
import com.restapi.contactsystem.service.ContactService;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    private final ContactService contactService;

    //controller injection
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/{id}")
    public Contact getContact(@PathVariable("id") int id) {
        Contact contact = Optional.ofNullable(contactService.findById(id))
                            .orElseThrow(() -> new ResourceNotFoundException("Contact id not found " + id));

        return contact;
    }

    @GetMapping
    public List<Contact> getAlleContacts() {
        return contactService.findAll();
    }

    @PostMapping
    public Contact saveContacts(@RequestBody Contact contact) {
        contact.setId(0);
        contactService.save(contact);
        return contact;
    }

    @PutMapping("/{id}")
    public Contact updateContacts(@PathVariable("id") int id, @RequestBody Contact contact) {

        Optional.ofNullable(contactService.findById(id))
                .orElseThrow(() -> new ResourceNotFoundException("Contact id not found -> " + id));

        contact.setId(id);
        contactService.save(contact);
        return contact;

    }

    @DeleteMapping("/{id}")
    public String deleteContact(@PathVariable int id){

        Optional.ofNullable(contactService.findById(id))
                            .orElseThrow(() -> new ResourceNotFoundException("Contact id not found -> " + id));

        contactService.deleteById(id);
        return "Deleted contact id is -> " + id;
    }
}
