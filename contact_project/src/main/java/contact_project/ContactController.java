package contact_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.List;

@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/contact")
    public String contact( Model model) {

        model.addAttribute("contacts",contactService.getAllContacts());
        return "contact";
    }

    @GetMapping(value="/xml/contact/{id}",produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public String GetContactById(@PathVariable (name="id", required=true) Long id ) throws JAXBException {
        Contact contact= contactService.getContactById(id);
        JAXBContext jaxbContext = JAXBContext.newInstance(Contact.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(contact, stringWriter);
        return stringWriter.toString();
    }

    @GetMapping(value="/xml/contacts",produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public Listcontact GetContacts()  {
        List<Contact> contactList = contactService.getAllContacts();
        Listcontact listcontact=new Listcontact(contactList);
        return listcontact;
    }


    @PostMapping("/xml/contact/add")
    public String AddContact(@RequestParam(name="fullname") String fullname, Model model) {
        contactService.addContact(fullname);

        model.addAttribute("contacts",contactService.getAllContacts());
        return "contact";
    }

    @PostMapping("/xml/contact/delete/{id}")
    public String DeleteContact(@PathVariable(name="id", required=true) Long id, Model model) {
        contactService.deleteContactById(id);

        model.addAttribute("contacts",contactService.getAllContacts());
        return "contact";
    }

    @PostMapping("/xml/contact/update/{id}")
    public String UpdateContact(@PathVariable(name="id", required=true) Long id, @RequestParam(name="fullname") String fullname, Model model) {
        contactService.updateContactById(id, fullname);

        model.addAttribute("contacts",contactService.getAllContacts());
        return "contact";
    }

}


