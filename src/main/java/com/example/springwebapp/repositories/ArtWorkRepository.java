package com.example.springwebapp.repositories;

import com.example.springwebapp.domain.ArtWork;
import org.springframework.data.repository.CrudRepository;

public interface ArtWorkRepository extends CrudRepository<ArtWork, Long> {
}
