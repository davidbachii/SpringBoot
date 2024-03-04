package com.example.cursospringboot.repository;

import com.example.cursospringboot.entity.FootballContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FootballContentRepository extends JpaRepository<FootballContent, Long> {
}
