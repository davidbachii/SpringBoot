package com.example.cursospringboot.repository;


import com.example.cursospringboot.entity.LiveContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface LiveContentRepository extends JpaRepository<LiveContent, Long> {

    List<LiveContent> findByStartTime(LocalDateTime startTime);
    List<LiveContent> findByEndTime(LocalDateTime endTime);
}
