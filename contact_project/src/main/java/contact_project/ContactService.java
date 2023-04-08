package contact_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public Contact getContactById(Long id) {
        return contactRepository.getById(id);
    }

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public void addContact(String fullname) {
        Contact contact = new Contact(fullname);
        contactRepository.save(contact);
    }

    public void deleteContactById(Long id) {
        contactRepository.deleteById(id);
    }

    public void updateContactById(Long id, String fullname) {
        Contact contact = contactRepository.getById(id);
        contact.setFullname(fullname);
        contactRepository.save(contact);
    }
}
