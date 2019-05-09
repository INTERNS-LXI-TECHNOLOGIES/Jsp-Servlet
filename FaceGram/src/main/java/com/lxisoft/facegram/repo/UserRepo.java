package com.lxisoft.facegram.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lxisoft.facegram.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

	User findByUsername(String username);
}
