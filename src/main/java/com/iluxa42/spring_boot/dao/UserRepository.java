package com.iluxa42.spring_boot.dao;

import com.iluxa42.spring_boot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}