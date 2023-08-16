package com.practica.rick_morty.prueba.repository;

import com.practica.rick_morty.prueba.models.Characters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<Characters, Integer> {
}
