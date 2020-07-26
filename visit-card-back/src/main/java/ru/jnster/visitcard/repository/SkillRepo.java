package ru.jnster.visitcard.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.jnster.visitcard.domain.Skill;

public interface SkillRepo extends JpaRepository<Skill, Integer> {

    Page<Skill> findAll(Pageable pageable);

}
