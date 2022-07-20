package Truecaller.data.repositories;

import Truecaller.data.models.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactRepositoryImpl implements ContactRepository{
    private int counter;
    private  List<Contact> contacts = new ArrayList<>();
    @Override
    public Contact save(Contact contact) {
        counter++;
        contact.setContactID(1);
        contact.add(contact);
        return contact;
    }

    @Override
    public void delete(Contact contact) {

    }

    @Override
    public void delete(int contactID) {

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
    public List<Contact> findByFirstName(String firstName) {
        return null;
    }

    @Override
    public List<Contact> findByLastName(String lastName) {
        return null;
    }

    @Override
    public List<Contact> findAll() {
        return null;
    }

    @Override
    public int count() {
        return contacts.size();
    }
}
