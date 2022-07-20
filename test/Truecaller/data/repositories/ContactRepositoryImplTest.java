package Truecaller.data.repositories;

import Truecaller.data.models.Contact;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactRepositoryImplTest {
    @Test
    public void saveContact_countIncreasesTest() {
        ContactRepository contactRepository = new ContactRepositoryImpl();
        Contact contact = new Contact();
        contact.setPhoneNumber("08122935909");
        contact.setFirstName("John");
        contact.setLastName("Akintolu");
        contact.setEmailAddress("johneryakintolu@gmail.com");

        contactRepository.save(contact);
        assertEquals(1,contactRepository.count());
    }
    @Test
    public void saveContact_findByIDTest() {
        ContactRepository contactRepository = new ContactRepositoryImpl();
        Contact contact = new Contact();
        contact.setPhoneNumber("08122935909");
        contact.setFirstName("John");
        contact.setLastName("Akintolu");
        contact.setEmailAddress("johneryakintolu@gmail.com");
        contactRepository.save(contact);
        assertEquals(1,contactRepository.count());

        Contact savedContact = contactRepository.findByID(1);
        assertEquals("John", savedContact.getFirstName());
    }
}