package com.restapi.contactsystem.repository;

import com.restapi.contactsystem.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
