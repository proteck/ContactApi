package ch.proteck.contactapi.repository;

import ch.proteck.contactapi.jpa.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {

    Skill findByName(String name);

}
