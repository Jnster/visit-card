package ru.jnster.visitcard.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Achievement {
  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  private Integer id;
  @Column(nullable = false)
  private String description;
  @JsonIgnore
  @ManyToOne
  private Job job;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Job getJob() {
    return job;
  }

  public void setJob(Job job) {
    this.job = job;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Achievement that = (Achievement) o;
    return description.equals(that.description) &&
        job.equals(that.job);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, job);
  }
}
