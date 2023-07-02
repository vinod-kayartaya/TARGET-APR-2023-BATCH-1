package com.targetindia.controllers;

import com.targetindia.entity.Contact;
import com.targetindia.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/contacts")
@Slf4j
public class ContactsController {

    @Autowired
    private ContactRepository repo;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity handlePostOne(@RequestBody Contact contact){
        log.trace("ContactsController.handlePostOne() called with {}", contact);
        contact.setId(null);
        contact = repo.save(contact);
        return ResponseEntity.status(HttpStatus.CREATED).body(contact);
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity handleGetAll() {
        log.trace("ContactsController.handleGetAll() called");

        return ResponseEntity.ok(repo.findAll());
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity handleGetOne(@PathVariable Integer id) {
        log.trace("ContactsController.handleGetOne() called with id {}", id);

        Optional<Contact> result = repo.findById(id);
        if (result.isEmpty()) {
            Map<String, Object> map = new HashMap<>();
            map.put("message", "No data found for id " + id);
            map.put("timestamp", new Date());
            return ResponseEntity.status(404).body(map);
        }

        return ResponseEntity.ok(result.get());
    }
}
