package com.example.cursospringboot.repository;

import com.example.cursospringboot.entity.F1Content;
import com.example.cursospringboot.entity.FootballContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface FootballContentRepository extends JpaRepository<FootballContent, Long> {

    Optional<FootballContent> findByNombreContenido(String nombreContenido);
}
