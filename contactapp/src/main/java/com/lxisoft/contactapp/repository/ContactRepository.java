package com.lxisoft.contactapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lxisoft.contactapp.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
