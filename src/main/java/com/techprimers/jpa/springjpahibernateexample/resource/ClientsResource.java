package com.techprimers.jpa.springjpahibernateexample.resource;

import com.techprimers.jpa.springjpahibernateexample.model.Clients;
import com.techprimers.jpa.springjpahibernateexample.model.Rooms;
import com.techprimers.jpa.springjpahibernateexample.repository.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/clients")
public class ClientsResource {

    @Autowired
    ClientsRepository clientsRepository;

    @GetMapping("/all")
    public List<Rooms> getAll() {
        return clientsRepository.findAll();
    }

    @GetMapping("/{name}")
    public List<Clients> getUser(@PathVariable("name") final String name) {
        return clientsRepository.findByName(name);
    }

//    @GetMapping("/update/{id}/{name}")
//    public Clients update(@PathVariable("id") final Integer id, @PathVariable("name") final String name) {
//        Rooms clients = clientsRepository.findById(id).orElse(null);
//        clients.setName(name);
//        return clientsRepository.save(clients);
//    }
}