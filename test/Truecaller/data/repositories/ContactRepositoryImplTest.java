package Truecaller.data.repositories;

import Truecaller.data.models.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactRepositoryListImplTest {
    ContactRepository contactRepository;
    Contact contact;
    @BeforeEach
    void setUp(){
        contactRepository = new ContactRepositoryImpl();
        contact =  new Contact("John",
                "Akintolu","08122935909","john@gmail.com");
    }
    @Test
    public void saveAndUpdateTest(){
        contactRepository.save(contact);
        Contact savedContact = contactRepository.findById(1);
        savedContact.setEmail("johnery@gmail.com");
        contactRepository.save(savedContact);

        assertEquals("johnery@gmail.com",contactRepository.findById(1).getEmail());
        assertEquals(2, contactRepository.count());

    }
}