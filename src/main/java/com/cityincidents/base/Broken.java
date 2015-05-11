package com.cityincidents.base;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Oscar on 02/05/2015.
 */
@Entity
public class Broken {
    private int id;
    private Timestamp date;
    private List<Person> person;
    private List<Incident> incident;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Broken broken = (Broken) o;

        if (id != broken.id) return false;
        if (date != null ? !date.equals(broken.date) : broken.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "broken")
    public List<Person> getPerson() {
        return person;
    }

    public void setPerson(List<Person> person) {
        this.person = person;
    }

    @OneToMany(mappedBy = "broken")
    public List<Incident> getIncident() {
        return incident;
    }

    public void setIncident(List<Incident> incident) {
        this.incident = incident;
    }
}
