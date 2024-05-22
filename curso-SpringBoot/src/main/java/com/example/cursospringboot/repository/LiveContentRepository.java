package com.example.cursospringboot.repository;


import com.example.cursospringboot.entity.LiveContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface LiveContentRepository extends JpaRepository<LiveContent, Long> {

    List<LiveContent> findByStartTime(LocalDateTime startTime);
    List<LiveContent> findByEndTime(LocalDateTime endTime);

    Optional<LiveContent> findByNombreContenido(String nombreContenido);

    // Verificar si ahi otros contenidos en directo en ese tramo horario

    @Query("SELECT CASE WHEN COUNT(lc) > 0 THEN true ELSE false END FROM LiveContent lc WHERE " +
            "(lc.startTime <= :endTime AND lc.endTime >= :startTime)")
    boolean existsOverlappingLiveContents(LocalDateTime startTime, LocalDateTime endTime);



    @Query("SELECT lc FROM LiveContent lc WHERE lc.startTime <= :now AND lc.endTime >= :now")
    List<LiveContent> findActiveLiveContents(@Param("now") LocalDateTime now);

    @Query("SELECT lc FROM LiveContent lc WHERE lc.startTime > :now ORDER BY lc.startTime")
    List<LiveContent> findFutureLiveContents(@Param("now") LocalDateTime now);
}
