package com.techprimers.jpa.springjpahibernateexample.repository;

import com.techprimers.jpa.springjpahibernateexample.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Integer> {
//    Optional<List<Users>> findByName(String name);
    List<Users> findByName(String name);
}
