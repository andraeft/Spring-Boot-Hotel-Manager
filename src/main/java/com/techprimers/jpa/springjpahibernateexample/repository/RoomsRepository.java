package com.techprimers.jpa.springjpahibernateexample.repository;

import com.techprimers.jpa.springjpahibernateexample.model.Rooms;
import com.techprimers.jpa.springjpahibernateexample.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomsRepository extends JpaRepository<Rooms, Integer> {
    //    Optional<List<Users>> findByName(String name);
    List<Users> findByName(String name);
}