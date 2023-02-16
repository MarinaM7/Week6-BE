package com.marina.Giorno4Security.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marina.Giorno4Security.entities.User;
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

}
