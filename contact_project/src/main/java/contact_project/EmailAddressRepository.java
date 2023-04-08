package contact_project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailAddressRepository extends JpaRepository<EmailAddress, Long> {

}

