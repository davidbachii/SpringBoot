package com.example.cursospringboot.repository;

import com.example.cursospringboot.entity.ComentarioF1;
import com.example.cursospringboot.entity.ComentarioFootball;
import com.example.cursospringboot.entity.F1Content;
import com.example.cursospringboot.entity.FootballContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComentarioFootballRepository extends JpaRepository<ComentarioFootball, Long> {

    List<ComentarioFootball> findByFootballContent(FootballContent footballContent);
}
