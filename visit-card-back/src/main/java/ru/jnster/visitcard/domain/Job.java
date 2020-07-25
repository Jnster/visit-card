package ru.jnster.visitcard.domain;

import java.sql.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    @Column(nullable = false)
    private String company;
    @Column(nullable = false)
    private Date start;
    private Date finish;
    @Column(nullable = false)
    private String position;
    @ElementCollection
    private List<String> achievements;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getFinish() {
        return finish;
    }

    public void setFinish(Date finish) {
        this.finish = finish;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<String> getAchievements() {
        return achievements;
    }

    public void setAchievements(List<String> achievements) {
        this.achievements = achievements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return company.equals(job.company) &&
                start.equals(job.start) &&
                finish.equals(job.finish) &&
                position.equals(job.position) &&
                Objects.equals(achievements, job.achievements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(company, start, finish, position);
    }
}
