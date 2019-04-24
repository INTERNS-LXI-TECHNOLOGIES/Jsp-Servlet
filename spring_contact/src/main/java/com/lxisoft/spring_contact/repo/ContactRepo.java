package com.lxisoft.spring_contact.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lxisoft.spring_contact.model.Contact;

@Repository
public interface ContactRepo extends JpaRepository<Contact, Integer>{

}
