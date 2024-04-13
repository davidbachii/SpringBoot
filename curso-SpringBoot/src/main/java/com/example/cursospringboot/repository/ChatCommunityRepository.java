package com.example.cursospringboot.repository;


import com.example.cursospringboot.entity.ChatCommunity;
import com.example.cursospringboot.entity.ChatMessage;
import com.example.cursospringboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChatCommunityRepository extends JpaRepository<ChatCommunity, Long> {

    ChatCommunity findByNombreComunidad(String nombreComunidad);




}
