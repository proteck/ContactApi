package ch.proteck.contactapi.controller;

import ch.proteck.contactapi.exception.ContactNotFoundException;
import ch.proteck.contactapi.jpa.Contact;
import ch.proteck.contactapi.jpa.Skill;
import ch.proteck.contactapi.repository.ContactRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class ContactController {

    @Autowired
    ContactRepository repository;

    @GetMapping("/contacts/{id}")
    @ApiOperation(value = "Getting contact with specific id")
    public Contact one(@PathVariable(value = "id") Long id) throws ContactNotFoundException {
        return repository.findById(id).orElseThrow(ContactNotFoundException::new);
    }

    @GetMapping("/contacts")
    @ApiOperation(value = "Getting all the contacts")
    public List<Contact> all() {
        return repository.findAll();
    }

    /**
     * Create a new {@link Contact}
     * Request body data
     *
     * @param contact
     * @return
     */
    @PostMapping("/contacts")
    @ApiOperation(value = "Create Contact")
    public Contact create(@RequestBody Contact contact) {
        return repository.save(contact);
    }

    /**
     * Update some {@link Contact}
     *
     * @param id
     * @param contact
     * @return
     */
    @ApiOperation(value = "Update specific Contact")
    @PutMapping("/contacts/{id}")
    public Contact update(@PathVariable(value = "id") Long id, @RequestBody Contact contact) throws ContactNotFoundException {
        Contact origin = repository.findById(id).orElseThrow(ContactNotFoundException::new);

        origin.setName(contact.getName());
        origin.setFirstName(contact.getFirstName());
        origin.setEmail(contact.getEmail());
        origin.setAdresse(contact.getAdresse());
        origin.setPhone(contact.getPhone());

        return repository.save(origin);
    }

    /**
     * Remove one {@link Contact}
     *
     * @param id
     */
    @DeleteMapping("/contacts/{id}")
    @ApiOperation(value = "Delete specific contact")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws ContactNotFoundException {
        Contact contact = repository.findById(id).orElseThrow(ContactNotFoundException::new);

        repository.delete(contact);

        return ResponseEntity.ok().build();
    }

    /**
     * Return skills for {@link Contact}
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "Return skills for contact")
    @GetMapping("/contacts/{id}/skills")
    public Set<Skill> skills(@PathVariable(value = "id") Long id) throws ContactNotFoundException {
        return repository.findById(id).orElseThrow(ContactNotFoundException::new).getSkills();
    }

    /**
     * Get {@link Contact} from email
     *
     * @param email
     * @return
     */
    @GetMapping("/contact/email/{email}")
    @ApiOperation(value = "Find contact by email")
    public Contact findByEmail(@PathVariable(value = "email") String email) {
        return repository.findByEmail(email);
    }

    /**
     * Get set of {@link Contact} with certain name
     *
     * @param name
     * @return
     */
    @GetMapping("/contacts/name/{name}")
    @ApiOperation(value = "Getting set of contact from name")
    public Set<Contact> findByName(@PathVariable(value = "name") String name) {
        return repository.findByName(name);
    }

    /**
     * Return set of {@link Contact} with certain firstname
     *
     * @param firstname
     * @return
     */
    @GetMapping("/contacts/firstName/{firstName}")
    @ApiOperation(value = "Getting set of contact from firstName")
    public Set<Contact> findByFirstName(@PathVariable(value = "firstName") String firstname) {
        return repository.findByFirstName(firstname);
    }
}
