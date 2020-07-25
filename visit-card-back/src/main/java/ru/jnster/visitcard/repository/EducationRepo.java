package ru.jnster.visitcard.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.jnster.visitcard.domain.Education;

public interface EducationRepo extends JpaRepository<Education, Integer> {

  Page<Education> findAll(Pageable pageable);

}
