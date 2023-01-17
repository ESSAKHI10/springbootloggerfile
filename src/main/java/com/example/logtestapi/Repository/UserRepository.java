 
 package com.example.logtestapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.logtestapi.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
