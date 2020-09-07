package ch.proteck.contactapi.controller;

import ch.proteck.contactapi.exception.ContactNotFoundException;
import ch.proteck.contactapi.exception.SkillNotFoundException;
import ch.proteck.contactapi.jpa.Skill;
import ch.proteck.contactapi.repository.SkillRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SkillController {

    @Autowired
    SkillRepository repository;

    @GetMapping("/skills")
    @ApiOperation(value = "Return all skills")
    public List<Skill> all() {
        return repository.findAll();
    }

    @GetMapping("/skills/{id}")
    @ApiOperation(value = "Return specific skill")
    public Skill one(@PathVariable(value = "id") Long id) throws ContactNotFoundException {
        return repository.findById(id).orElseThrow(ContactNotFoundException::new);
    }

    @PostMapping("/skills")
    @ApiOperation(value = "Create skill")
    public Skill create(@RequestBody Skill skill) {
        return repository.save(skill);
    }

    @PutMapping("/skills/{id}")
    @ApiOperation(value = "Update certain skill")
    public Skill update(@PathVariable(value = "id") Long id, @RequestBody Skill skill) throws SkillNotFoundException {
        Skill origin = repository.findById(id).orElseThrow(SkillNotFoundException::new);

        origin.setName(skill.getName());

        return repository.save(origin);
    }

    @GetMapping("/skills/name/{name}")
    @ApiOperation(value = "Find by skill name")
    public Skill findBaName(@PathVariable(value = "name") String name) {
        return repository.findByName(name);
    }

}
