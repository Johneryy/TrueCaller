package Truecaller.data.repositories;

import Truecaller.data.models.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactRepositoryMapImplTest {
    ContactRepository contactRepository;
    Contact contact;
    @BeforeEach
    void setUp(){
        contactRepository = new ContactRepositoryMapImpl();
        contact =  new Contact("John",
                "Akintolu","08122935909","john@mail.com");
    }
    @Test
    public void saveContact_countIncreasesTest(){
        contactRepository.save(contact);
        assertEquals(1, contactRepository.count());
    }
    @Test
    public void saveContact_findByIdTest(){
        contactRepository.save(contact);
        assertEquals(1, contactRepository.count());

        Contact savedContact = contactRepository.findById(1);
        assertEquals("John",savedContact.getFirstName());
    }
    @Test
    public void saveAndDeleteContactByIDTest(){
        contactRepository.save(contact);
        assertEquals(1, contactRepository.count());

        Contact savedContact = contactRepository.findById(1);
        assertEquals("John",savedContact.getFirstName());

        contactRepository.delete(1);
        assertEquals(1, contactRepository.count());
    }
    @Test
    public void saveAndDeleteContactByObjectTest(){
        contactRepository.save(contact);
        assertEquals(1, contactRepository.count());

        Contact savedContact = contactRepository.findById(1);
        assertEquals("John",savedContact.getFirstName());

        contactRepository.delete(savedContact);
        assertEquals(1, contactRepository.count());

        assertNull(contactRepository.findById(1));
    }
    @Test
    public void saveAndFindByFirstNameTest(){
        contactRepository.save(contact);
        contactRepository.save(new Contact("John","Akintolu","09126131736","akin@gmail.com"));
        assertEquals(2, contactRepository.count());
        Contact savedContact = contactRepository.findById(1);
        assertEquals("John",savedContact.getFirstName());

        assertEquals(2,contactRepository.findByFirstName("John").size());
        assertEquals(2,contactRepository.findByLastName("Akintolu").size());
    }
    @Test
    public void saveAndUpdateTest(){
        contactRepository.save(contact);
        Contact savedContact = contactRepository.findById(1);
        System.out.println(savedContact);
        savedContact.setEmail("johnny");
        contactRepository.save(savedContact);

        assertEquals("johnny",contactRepository.findById(1).getEmail());
        assertEquals(2, contactRepository.count());

    }
}