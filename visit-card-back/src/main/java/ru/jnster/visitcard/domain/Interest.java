package ru.jnster.visitcard.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Interest {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    @Column(nullable = false)
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interest interest = (Interest) o;
        return name.equals(interest.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
