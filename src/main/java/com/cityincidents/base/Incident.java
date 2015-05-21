package com.cityincidents.base;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Oscar on 19/05/2015.
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
    private Person id_person;
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
        if (description != null ? !description.equals(incident.description) : incident.description != null)
            return false;
        if (!Arrays.equals(image, incident.image)) return false;
        if (createdate != null ? !createdate.equals(incident.createdate) : incident.createdate != null) return false;
        if (lastmodificationdate != null ? !lastmodificationdate.equals(incident.lastmodificationdate) : incident.lastmodificationdate != null)
            return false;
        if (latitude != null ? !latitude.equals(incident.latitude) : incident.latitude != null) return false;
        if (longitude != null ? !longitude.equals(incident.longitude) : incident.longitude != null) return false;
        if (address != null ? !address.equals(incident.address) : incident.address != null) return false;

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

    @OneToOne
    @JoinColumn(name = "id_person", referencedColumnName = "id")
    public Person getId_person() {
        return id_person;
    }

    public void setId_person(Person id_person) {
        this.id_person = id_person;
    }

    @OneToMany(mappedBy = "id_incident")
    public List<Fixed> getFixed() {
        return fixed;
    }

    public void setFixed(List<Fixed> fixed) {
        this.fixed = fixed;
    }

    @OneToMany(mappedBy = "id_incident")
    public List<Broken> getBroken() {
        return broken;
    }

    public void setBroken(List<Broken> broken) {
        this.broken = broken;
    }
}
