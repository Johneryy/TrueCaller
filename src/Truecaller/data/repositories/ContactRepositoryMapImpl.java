package Truecaller.data.repositories;
;

import Truecaller.data.models.Contact;

import java.util.*;
import java.util.stream.Collectors;

public class ContactRepositoryMapImpl implements ContactRepository{
    private int counter;
    private Map<Integer, Contact> contacts = new HashMap<>();
    @Override
    public Contact save(Contact contact) {
        if(contact.getContactID()== 0){
            counter++;
            contact.setContactID(counter);
            contacts.put(counter,contact);
        }

        return contact;
    }

    @Override
    public void delete(Contact contact) {
        contacts.remove(contact.getContactID());
    }

    @Override
    public void delete(int id) {
        contacts.remove(findById(id).getContactID());
    }

    @Override
    public Contact findByID(int contactID) {
        return contacts.get(contactID);
    }

    @Override
    public Contact findById(int id) {
        return contacts.get(id);
    }

    @Override
    public List<Contact> findByFirstName(String firstName) {
        return contacts.values().stream()
                .filter((contact -> contact.getFirstName().equalsIgnoreCase(firstName)))
                .collect(Collectors.toList());
    }

    @Override
    public List<Contact> findByLastName(String lastName) {
        return contacts.values().stream()
                .filter((contact -> contact.getLastName().equalsIgnoreCase(lastName)))
                .collect(Collectors.toList());
    }

    @Override
    public List<Contact> findAll() {
        return (List<Contact>) contacts.values();
    }

    @Override
    public int count() {
        return contacts.size();
    }
}