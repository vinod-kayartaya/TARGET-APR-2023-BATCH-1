package com.targetindia.controllers;

import com.targetindia.model.AppInfo;
import com.targetindia.model.Contact;
import com.targetindia.model.ContactList;
import com.targetindia.model.ErrorInfo;
import com.targetindia.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/contacts")
public class ContactsController {

    @Autowired
    private ContactService service;

    // @RequestMapping(path="/api/contacts/info", produces = "text/plain", method = RequestMethod.GET)
    @GetMapping(path = "/info", produces = "text/plain")
    public String info() {
        return "ContactsController\nVersion 1.0.0\nAuthor: Vinod Kumar K <vinod@vinod.co>";
    }

    @GetMapping(path = "/info", produces = {"application/json", "application/xml"})
    public AppInfo infoAsJson() {
        return new AppInfo(
                "ContactsController",
                "Versoin 1.0.0",
                "Viond Kumar K",
                "vinod@viond.co");
    }

    @PostMapping(consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    public ResponseEntity handlePost(@RequestBody Contact contact) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.add(contact));
        } catch (Exception e) {
            ErrorInfo err = new ErrorInfo(e.getMessage(), e.getClass().getName());
            return ResponseEntity.status(499).body(err);
        }
    }

    @GetMapping(path = "/{id}", produces = {"application/json", "application/xml"})
    public ResponseEntity handleGetOne(@PathVariable Integer id) {
        Contact c = service.getById(id);
        if (c == null) {
            ErrorInfo err = new ErrorInfo("No data found for id " + id);
            return ResponseEntity.status(404).body(err);
        }
        return ResponseEntity.ok(c);
    }

    @PutMapping(path = "/{id}", consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    public ResponseEntity handlePut(@PathVariable Integer id, @RequestBody Contact contact) {
        contact.setId(id);
        try {
            service.update(contact);
            return ResponseEntity.status(HttpStatus.CREATED).body(contact);
        } catch (Exception e) {
            ErrorInfo err = new ErrorInfo(e.getMessage(), e.getClass().getName());
            return ResponseEntity.status(499).body(err);
        }
    }

    @GetMapping(produces = {"application/json", "application/xml"})
    public ResponseEntity handleGetAll() {
        List<Contact> list = new ArrayList<>();
        list.addAll(service.getAll());
        return ResponseEntity.ok(new ContactList(list));
    }

    @GetMapping(path = "/search", produces = {"application/json", "application/xml"})
    public ResponseEntity handleGetSearch(
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String phone) {

        Contact c1;
        if (city != null) {
            return ResponseEntity.ok(new ContactList(service.getByCity(city)));
        } else if (email != null) {
            c1 = service.getByEmail(email);
            if (c1 == null) {
                ErrorInfo err = new ErrorInfo("No contact found for email: " + email);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
            }
            return ResponseEntity.ok(c1);
        } else if (phone != null) {
            c1 = service.getByPhone(phone);
            if (c1 == null) {
                ErrorInfo err = new ErrorInfo("No contact found for phone: " + phone);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
            }
            return ResponseEntity.ok(c1);
        } else {
            ErrorInfo err = new ErrorInfo("You must pass one of these as query string parameter: city/email/phone");
            return ResponseEntity.status(498).body(err);
        }
    }
}
