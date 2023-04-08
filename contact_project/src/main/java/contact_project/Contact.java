package contact_project;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table(name = "contact")
public class Contact {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String fullname;

    @ManyToOne
    @JoinColumn(name = "address",referencedColumnName = "name")
    private PostalAddress postalAddress;

    @ManyToOne
    @JoinColumn(name = "email",referencedColumnName = "name")
    private EmailAddress emailAddress;

    public Contact() {}

    public Contact(String fullname) {
        this.fullname = fullname;
    }
    public Contact(String fullname, PostalAddress postalAddress, EmailAddress emailAddress) {
        this.fullname = fullname;
        this.postalAddress = postalAddress;
        this.emailAddress = emailAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPostalAddressName() {
        if(postalAddress!=null){
            return postalAddress.getName();
        }else{
            return null;
        }
    }

    public void setPostalAddressName(String name) {
        this.postalAddress.setName(name);
    }

    public void setPostalAddress(PostalAddress postalAddress) {
        this.postalAddress=postalAddress;
    }

    public String getEmailAddressName() {
        if(emailAddress!=null){
            return emailAddress.getName();
        }else{
            return null;
        }
    }

    public void setEmailAddressName(String name) {
        this.emailAddress.setName(name);
    }

    public void setEmailAddress(EmailAddress emailAddress) {
        this.emailAddress=emailAddress;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", Adresse='" + postalAddress.getName() + '\'' +
                ", EmailAddress='" + emailAddress.getName() + '\'' +
                '}';
    }
}
