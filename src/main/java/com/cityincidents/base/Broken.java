package com.cityincidents.base;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Oscar on 19/05/2015.
 */
@Entity
public class Broken {
    private int id;
    private Timestamp date;
    private Person id_person;
    private Incident id_incident;

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

    @ManyToOne
    @JoinColumn(name = "id_person", referencedColumnName = "id")
    public Person getId_person() {
        return id_person;
    }

    public void setId_person(Person id_person) {
        this.id_person = id_person;
    }

    @ManyToOne
    @JoinColumn(name = "id_incident", referencedColumnName = "id")
    public Incident getId_incident() {
        return id_incident;
    }

    public void setId_incident(Incident id_incident) {
        this.id_incident = id_incident;
    }
}
