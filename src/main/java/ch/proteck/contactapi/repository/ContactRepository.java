package ch.proteck.contactapi.repository;

import ch.proteck.contactapi.jpa.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    Contact findByEmail(String email);

    Set<Contact> findByName(String name);

    Set<Contact> findByFirstName(String firstName);

}
