package Truecaller.data.repositories;

import Truecaller.data.models.Contact;
import java.util.*;

public interface ContactRepository {
    Contact save(Contact contact);
    void delete(Contact contact);
    void delete(int contactID);
    Contact findByID(int contactID);

    Contact findById(int id);

    List<Contact> findByFirstName(String firstName);
    List<Contact> findByLastName(String lastName);
    List<Contact> findAll();
    int count();
}
