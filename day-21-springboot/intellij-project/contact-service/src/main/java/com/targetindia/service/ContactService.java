package com.targetindia.service;

import com.targetindia.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ContactService {

    private String filename = "contacts.dat";
    private Map<Integer, Contact> contacts = new TreeMap<>();

    public ContactService() {
        loadFromFile();
    }

    private void loadFromFile() {
        if (Files.exists(Path.of(filename))) {
            try (
                    FileInputStream file = new FileInputStream(filename);
                    ObjectInputStream in = new ObjectInputStream(file)
            ) {
                this.contacts = (Map<Integer, Contact>) in.readObject();
            } catch (Exception e) {
                throw new ServiceException(e);
            }
        }
    }

    private void saveToFile() {
        try (
                FileOutputStream file = new FileOutputStream(filename);
                ObjectOutputStream out = new ObjectOutputStream(file)
        ) {
            out.writeObject(contacts);
        } catch (IOException e) {
            throw new ServiceException(e);
        }
    }

    int newId() {
        if (contacts.size() == 0) {
            return 1;
        }
        return 1 + contacts.keySet()
                .stream()
                .mapToInt(k -> k)
                .max()
                .getAsInt();
    }

    public Contact add(Contact contact) throws ServiceException {
        // validations
        if (contact.getName() == null || contact.getName().isBlank()) {
            throw new ServiceException("Name cannot be null or blank");
        }

        if (contact.getEmail() == null || contact.getEmail().isBlank()) {
            throw new ServiceException("Email cannot be null or blank");
        }

        if (this.getByEmail(contact.getEmail()) != null) {
            throw new ServiceException("Contact with this email already present");
        }
        if (this.getByPhone(contact.getPhone()) != null) {
            throw new ServiceException("Contact with this phone already present");
        }

        // assign a new id
        contact.setId(this.newId());
        contacts.put(contact.getId(), contact);
        saveToFile();
        return contact;
    }

    public Contact getByEmail(String email) {
        Optional<Contact> result = contacts.values()
                .stream()
                .filter(c -> c.getEmail().equals(email))
                .findFirst();
        return result.isPresent() ? result.get() : null;
    }

    public Contact getByPhone(String phone) {
        Optional<Contact> result = contacts.values()
                .stream()
                .filter(c -> c.getPhone() != null && c.getPhone().equals(phone))
                .findFirst();
        return result.isPresent() ? result.get() : null;
    }

    public Contact getById(Integer id) {
        return this.contacts.get(id);
    }

    public List<Contact> getAll() {
        return this.contacts.values().stream().collect(Collectors.toList());
    }

    public List<Contact> getByCity(String city) {
        return this.contacts.values()
                .stream()
                .filter(c -> c.getCity() != null && c.getCity().toLowerCase().contains(city.toLowerCase()))
                .collect(Collectors.toList());
    }

    public void update(Contact c) throws ServiceException {
        log.trace("contact is {}", c);
        if (this.contacts.containsKey(c.getId())) {
            if (c.getName() == null || c.getName().isBlank()) {
                throw new ServiceException("Name cannot be null or blank");
            }

            if (c.getEmail() == null || c.getEmail().isBlank()) {
                throw new ServiceException("Email cannot be null or blank");
            }

            // email should not be equals to any other email (other than this contact's email)
            boolean emailExists = this.contacts.values().stream()
                    .filter(c1 -> !c1.getId().equals(c.getId()) && c1.getEmail().equals(c.getEmail()))
                    .findFirst()
                    .isPresent();
            if (emailExists) {
                throw new ServiceException("There is a contact with this email already present");
            }
            // phone should not be equals to any other phone (other than this contact's phone)
            // TODO: this doesn't seem like working. Check and fix the problem.
            boolean phoneExists = this.contacts.values().stream()
                    .filter(c1 -> !c1.getId().equals(c.getId()) && c1.getPhone().equals(c.getPhone()))
                    .findFirst()
                    .isPresent();
            if (phoneExists) {
                throw new ServiceException("There is a contact with this phone already present");
            }

            this.contacts.put(c.getId(), c);
            saveToFile();
            return;
        }
        throw new ServiceException("Contact with the given id not found");
    }

    public void delete(Integer id) throws ServiceException {
        if (this.contacts.containsKey(id)) {
            this.contacts.remove(id);
            saveToFile();
        }
        throw new ServiceException("Contact with the given id not found");
    }

}
