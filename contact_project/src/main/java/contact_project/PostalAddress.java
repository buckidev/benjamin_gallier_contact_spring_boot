package contact_project;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "postal_address")
public class PostalAddress implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;

    public PostalAddress() {}

    public PostalAddress(String name) {
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
        return "PostalAddress{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
