package contact_project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PostalAddressRepository extends JpaRepository<PostalAddress, Long> {

}