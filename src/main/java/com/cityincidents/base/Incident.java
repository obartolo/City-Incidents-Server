package com.cityincidents.base;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Oscar on 02/05/2015.
 */
@Entity
public class Incident {
    private int id;
    private String description;
    private byte[] image;
    private Timestamp createdate;
    private Timestamp lastmodificationdate;
    private String latitude;
    private String longitude;
    private String address;
    private List<Person> person;
    private Broken broken;
    private Fixed fixed;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "image")
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Basic
    @Column(name = "createdate")
    public Timestamp getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Timestamp createdate) {
        this.createdate = createdate;
    }

    @Basic
    @Column(name = "lastmodificationdate")
    public Timestamp getLastmodificationdate() {
        return lastmodificationdate;
    }

    public void setLastmodificationdate(Timestamp lastmodificationdate) {
        this.lastmodificationdate = lastmodificationdate;
    }

    @Basic
    @Column(name = "latitude")
    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @Basic
    @Column(name = "longitude")
    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Incident incident = (Incident) o;

        if (id != incident.id) return false;
        if (address != null ? !address.equals(incident.address) : incident.address != null) return false;
        if (createdate != null ? !createdate.equals(incident.createdate) : incident.createdate != null) return false;
        if (description != null ? !description.equals(incident.description) : incident.description != null)
            return false;
        if (!Arrays.equals(image, incident.image)) return false;
        if (lastmodificationdate != null ? !lastmodificationdate.equals(incident.lastmodificationdate) : incident.lastmodificationdate != null)
            return false;
        if (latitude != null ? !latitude.equals(incident.latitude) : incident.latitude != null) return false;
        if (longitude != null ? !longitude.equals(incident.longitude) : incident.longitude != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (image != null ? Arrays.hashCode(image) : 0);
        result = 31 * result + (createdate != null ? createdate.hashCode() : 0);
        result = 31 * result + (lastmodificationdate != null ? lastmodificationdate.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "incident")
    public List<Person> getPerson() {
        return person;
    }

    public void setPerson(List<Person> person) {
        this.person = person;
    }

    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id_incident", nullable = false)
    public Broken getBroken() {
        return broken;
    }

    public void setBroken(Broken broken) {
        this.broken = broken;
    }

    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id_incident", nullable = false)
    public Fixed getFixed() {
        return fixed;
    }

    public void setFixed(Fixed fixed) {
        this.fixed = fixed;
    }
}
