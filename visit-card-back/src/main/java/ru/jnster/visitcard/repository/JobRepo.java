package ru.jnster.visitcard.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.jnster.visitcard.domain.Job;

public interface JobRepo extends JpaRepository<Job, Integer> {

  Page<Job> findAll(Pageable pageable);

}
