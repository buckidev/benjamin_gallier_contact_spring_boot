package contact_project;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Listcontact {
    private List<Contact> contactList;

    public Listcontact() {
        this.contactList = new ArrayList<Contact>();
    }

    public Listcontact(List<Contact> contactList) {
        this.contactList = contactList;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }
}
