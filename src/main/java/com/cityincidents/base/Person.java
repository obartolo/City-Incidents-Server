package com.cityincidents.base;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Oscar on 19/05/2015.
 */
@Entity
public class Person {
    private int id;
    private String name;
    private String lastname;
    private String phone;
    private String email;
    private String pass;
    private String city;
    private String address;
    private byte[] image;
    private Incident incidents;
    private List<Fixed> fixed;
    private List<Broken> broken;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "lastname")
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "pass")
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "image")
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != person.id) return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        if (lastname != null ? !lastname.equals(person.lastname) : person.lastname != null) return false;
        if (phone != null ? !phone.equals(person.phone) : person.phone != null) return false;
        if (email != null ? !email.equals(person.email) : person.email != null) return false;
        if (pass != null ? !pass.equals(person.pass) : person.pass != null) return false;
        if (city != null ? !city.equals(person.city) : person.city != null) return false;
        if (address != null ? !address.equals(person.address) : person.address != null) return false;
        if (!Arrays.equals(image, person.image)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (pass != null ? pass.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (image != null ? Arrays.hashCode(image) : 0);
        return result;
    }

    @OneToOne(mappedBy = "id_person")
    public Incident getIncidents() {
        return incidents;
    }

    public void setIncidents(Incident incidents) {
        this.incidents = incidents;
    }

    @OneToMany(mappedBy = "id_person")
    public List<Fixed> getFixed() {
        return fixed;
    }

    public void setFixed(List<Fixed> fixed) {
        this.fixed = fixed;
    }

    @OneToMany(mappedBy = "id_person")
    public List<Broken> getBroken() {
        return broken;
    }

    public void setBroken(List<Broken> broken) {
        this.broken = broken;
    }
}
