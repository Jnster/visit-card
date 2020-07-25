package ru.jnster.visitcard.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.jnster.visitcard.domain.Interest;

public interface InterestRepo extends JpaRepository<Interest, Integer> {

    Page<Interest> findAll(Pageable pageable);

}
