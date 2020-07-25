package ru.jnster.visitcard.repository;

import java.sql.Date;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.jnster.visitcard.domain.Job;

public interface JobRepo extends JpaRepository<Job, Integer> {

  Page<Job> findAll(Pageable pageable);

  @Query(value = "select * from job where ((start >= ?1 and start <= ?2) or (finish >= ?1 and finish <= ?2))",
  nativeQuery = true)
  Page<Job> findAllByStartOrFinishBetween(Pageable pageable, Date from, Date to);

  @Query(value = "select * from job where ((start >= ?1 and start <= ?2) or (finish >= ?1 and finish <= ?2))",
      nativeQuery = true)
  List<Job> findAllByStartOrFinishBetween(Date from, Date to);

  @Query(value = "select * from job where (start >= ?1  or finish >= ?1)",
      nativeQuery = true)
  List<Job> findAllFrom(Date from);

  @Query(value = "select * from job where (start <= ?1 or  finish <= ?1)",
      nativeQuery = true)
  List<Job> findAllTo(Date to);

  @Query(value = "select * from job where (start >= ?1  or finish >= ?1)",
      nativeQuery = true)
  Page<Job> findAllFrom(Pageable pageable, Date from);

  @Query(value = "select * from job where (start <= ?1 or  finish <= ?1)",
      nativeQuery = true)
  Page<Job> findAllTo(Pageable pageable, Date to);
}
