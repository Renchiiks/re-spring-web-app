package com.example.springwebapp.repositories;

import com.example.springwebapp.domain.Exhibition;
import org.springframework.data.repository.CrudRepository;

public interface ExhibitionRepository extends CrudRepository<Exhibition, Long> {
}
