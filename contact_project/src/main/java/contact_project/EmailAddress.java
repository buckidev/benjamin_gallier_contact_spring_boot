package contact_project;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "email_address")
public class EmailAddress implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;

    public EmailAddress() {}

    public EmailAddress(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "EmailAddress{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
