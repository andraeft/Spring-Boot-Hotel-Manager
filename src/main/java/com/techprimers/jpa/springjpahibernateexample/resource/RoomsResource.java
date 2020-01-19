package com.techprimers.jpa.springjpahibernateexample.resource;

import com.techprimers.jpa.springjpahibernateexample.model.Rooms;
import com.techprimers.jpa.springjpahibernateexample.model.Users;
import com.techprimers.jpa.springjpahibernateexample.repository.RoomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rest/rooms")
public class RoomsResource {

    @Autowired
    RoomsRepository roomsRepository;

    @GetMapping("/all")
    public List<Rooms> getAll() {
        return roomsRepository.findAll();
    }

    @GetMapping("/{name}")
    public List<Users> getUser(@PathVariable("name") final String name) {
        return roomsRepository.findByName(name);
    }

    @GetMapping("/id/{id}")
    public Rooms getId(@PathVariable("id") final Integer id) {
        return roomsRepository.findById(id).orElse(null);
    }

    @GetMapping("/update/{id}/{name}")
    public Rooms update(@PathVariable("id") final Integer id, @PathVariable("name") final String name) {
        Rooms rooms = roomsRepository.findById(id).orElse(null);
        rooms.setName(name);
        return roomsRepository.save(rooms);
    }

    @GetMapping("/add/{name}/{people}")
    public Rooms addToList(@PathVariable("name") final String name, @PathVariable("people") final Integer people) {;

        List<Rooms> rooms = roomsRepository.findAll();
        Rooms newRoom = new Rooms();
        newRoom.setName(name);
        newRoom.setOccupied(false);
        newRoom.setClean(true);
        newRoom.setNumberOfPeople(people);
        rooms.add(newRoom);
        return roomsRepository.save(newRoom);
    }

    @PostMapping("/add")
    public Map<String, Object> save(Rooms room){
        Map<String, Object> map = new HashMap<>();
        try{
            map.put("id", roomsRepository.save(room));
            map.put("success", HttpStatus.ACCEPTED);
        } catch (Exception e){
            map.put("status", HttpStatus.BAD_REQUEST);
        }
        return map;
    }
}
