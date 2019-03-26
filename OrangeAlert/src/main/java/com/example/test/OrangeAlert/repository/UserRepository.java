package com.example.test.OrangeAlert.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.test.OrangeAlert.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
