package Truecaller.data.repositories;

import Truecaller.data.models.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ContactRepositoryImpl implements ContactRepository{
    private int counter;
    private  List<Contact> contacts = new ArrayList<>();
    @Override
    public Contact save(Contact contact) {
        if(contact.getContactID()==0){
            counter++;
            contact.setContactID(counter);
            contacts.add(contact);
            return contact;
        }
        delete(contact.getContactID());
        contacts.add(contact);
        return contact;
    }

    @Override
    public void delete(Contact contact) {
        contacts.remove(contacts);
    }

    @Override
    public void delete(int contactID) {
        for (Contact contact: contacts){
            if(contact.getContactID() == contactID){
                contacts.remove(contact);
                return;
            }
        }
    }

    @Override
    public Contact findByID(int contactID) {
        for(var contact : contacts){
            if(contact.getContactID()== contactID){
                return contact;
            }
        }
        return null;
    }

    @Override
    public Contact findById(int id) {
        return contacts.get(id-1);
    }

    @Override
    public List<Contact> findByFirstName(String firstName) {
        return contacts.stream().filter((contact -> contact.getFirstName()
                .equalsIgnoreCase(firstName))).collect(Collectors.toList());
    }
    @Override
    public List<Contact> findByLastName(String lastName) {
        return contacts.stream().filter((contact -> contact.getLastName()
                .equalsIgnoreCase(lastName))).collect(Collectors.toList());
    }
    @Override
    public List<Contact> findAll() {
        return contacts;
    }
    @Override
    public int count() {
        return contacts.size();
    }
}
