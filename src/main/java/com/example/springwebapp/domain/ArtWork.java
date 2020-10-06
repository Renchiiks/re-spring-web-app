package com.example.springwebapp.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class ArtWork {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String location;

    @ManyToMany
    @JoinTable(name = "artist_artWork", joinColumns = @JoinColumn(name = "artist_id"), inverseJoinColumns = @JoinColumn(name = "artWork_id"))
    private Set<Artist> artist = new HashSet<>();
    @ManyToOne(cascade = CascadeType.ALL)
    private Exhibition exhibition = new Exhibition();

    public ArtWork() {
    }

    public ArtWork( String name, String location) {
        this.name = name;
        this.location = location;
    }

    public Exhibition getExhibition() {
        return exhibition;
    }

    public void setExhibition(Exhibition exhibition) {
        this.exhibition = exhibition;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Set<Artist> getArtist() {
        return artist;
    }

    public void setArtist(Set<Artist> artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "ArtWork{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", artist=" + artist +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArtWork artWork = (ArtWork) o;
        return Objects.equals(id, artWork.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
