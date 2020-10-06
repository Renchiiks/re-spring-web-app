package com.example.springwebapp.repositories;

import com.example.springwebapp.domain.Artist;
import org.springframework.data.repository.CrudRepository;

public interface ArtistRepository extends CrudRepository<Artist, Long> {
}
