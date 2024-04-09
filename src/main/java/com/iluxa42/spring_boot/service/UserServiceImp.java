package com.iluxa42.spring_boot.service;

import com.iluxa42.spring_boot.dao.UserRepository;
import com.iluxa42.spring_boot.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

   private final UserRepository userRepository;

   @Autowired
   public UserServiceImp(UserRepository userRepository) {
      this.userRepository = userRepository;
   }

   @Override
   public User getUserById(int id) {
      User user = null;
      Optional<User> optional = userRepository.findById(id);

      if (optional.isPresent()) {
         user = optional.get();
      } else {
         System.out.println("User not found. id = " + id);
      }

      return user;
   }

   @Override
   public List<User> getAllUsers() {
      return userRepository.findAll();
   }

   @Override
   public void saveUser(User user) {
      userRepository.save(user);
   }

   @Override
   public void deleteUser(int id) {
      userRepository.deleteById(id);
   }
}