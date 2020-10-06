package com.example.springwebapp.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Exhibition {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    private String title;
    @OneToMany
    @JoinColumn(name = "exhibition_id")
    private Set<Artist> artists = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "exhibition_id")
    private Set<ArtWork> artWorks = new HashSet<>();

    public Exhibition() {
    }

    public Exhibition( String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Artist> getArtists() {
        return artists;
    }

    public void setArtists(Set<Artist> artists) {
        this.artists = artists;
    }

    public Set<ArtWork> getArtWorks() {
        return artWorks;
    }

    public void setArtWorks(Set<ArtWork> artWorks) {
        this.artWorks = artWorks;
    }

    @Override
    public String toString() {
        return "Exhibition{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", artists=" + artists +
                ", artWorks=" + artWorks +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exhibition that = (Exhibition) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
