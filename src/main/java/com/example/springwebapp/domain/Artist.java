package com.example.springwebapp.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
@Entity
public class Artist {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    private String firstName;
    private String lastName;

    @ManyToMany(mappedBy = "artist")
    private Set<ArtWork> artWorks = new HashSet<>();
    public Artist() {
    }

    public Artist( String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public Exhibition getExhibition() {
        return exhibition;
    }

    public void setExhibition(Exhibition exhibition) {
        this.exhibition = exhibition;
    }

    @ManyToOne(cascade = {CascadeType.ALL})
    private Exhibition exhibition = new Exhibition();



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<ArtWork> getArtWorks() {
        return artWorks;
    }

    public void setArtWorks(Set<ArtWork> artWorks) {
        this.artWorks = artWorks;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", artWorks=" + artWorks +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return Objects.equals(id, artist.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
