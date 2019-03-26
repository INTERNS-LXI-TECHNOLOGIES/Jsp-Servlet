package com.lxisoft.orangeAlert.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lxisoft.orangeAlert.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
}
