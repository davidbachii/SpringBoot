package com.example.cursospringboot.repository;

import com.example.cursospringboot.entity.ChatCommunity;
import com.example.cursospringboot.entity.ChatMessage;
import com.example.cursospringboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {

    List<ChatMessage> findBySentByAndCommunity(User user, ChatCommunity community);
    List<ChatMessage> findBySentByNotAndCommunity(User user, ChatCommunity community);
}
