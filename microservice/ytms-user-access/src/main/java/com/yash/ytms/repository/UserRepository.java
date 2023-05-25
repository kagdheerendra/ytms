package com.yash.ytms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.yash.ytms.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
}
