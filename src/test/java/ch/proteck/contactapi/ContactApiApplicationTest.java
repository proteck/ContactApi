package ch.proteck.contactapi;

import ch.proteck.contactapi.jpa.Contact;
import ch.proteck.contactapi.jpa.Skill;
import ch.proteck.contactapi.repository.ContactRepository;
import ch.proteck.contactapi.repository.SkillRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class ContactApiApplicationTest {

    private final List<String> listSkillStr = Arrays.asList("Java", "Spring", "Docker");

    @Autowired
    ContactRepository contactRepository;

    @Autowired
    SkillRepository skillRepository;

    @Test
    public void initSampleData() {
        /*
         * Create contact
         */
        Contact contactMaxime = new Contact();
        contactMaxime.setPhone("078 711 85 33");
        contactMaxime.setEmail("maxime@proteck.ch");
        contactMaxime.setFirstName("Maxime");
        contactMaxime.setName("Guillod");
        contactMaxime.setAdresse("Rue de la Cure 13 \n1410 Thierrens \nSuisse");
        contactRepository.save(contactMaxime);

        /*
         * Create all skills
         */
        for(String s : listSkillStr) {
            Skill skill = new Skill();
            skill.setName(s);
            skillRepository.save(skill);
        }

        /*
         * Add all skill to contact
         */
        for(Skill s : skillRepository.findAll()) {
            contactMaxime.getSkills().add(s);
        }
        contactRepository.save(contactMaxime);
    }

}