package com.example.cursospringboot.repository;


import com.example.cursospringboot.entity.ChatCommunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChatCommunityRepository extends JpaRepository<ChatCommunity, Long> {

    Optional<ChatCommunity> findByNombreComunidad(String nombreComunidad);
}
