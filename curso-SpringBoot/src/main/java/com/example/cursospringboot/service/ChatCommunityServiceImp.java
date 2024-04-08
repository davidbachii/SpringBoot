package com.example.cursospringboot.service;

import com.example.cursospringboot.entity.ChatCommunity;
import com.example.cursospringboot.repository.ChatCommunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatCommunityServiceImp {

    @Autowired
    private ChatCommunityRepository chatCommunityRepository;

    public List<ChatCommunity> getAllCommunities() {
        return chatCommunityRepository.findAll();
    }

    public ChatCommunity getCommunityById(Long id) {
        return chatCommunityRepository.findById(id).orElse(null);
    }

    public ChatCommunity getCommunityByName(String nombreComunidad) {
        return chatCommunityRepository.findByNombreComunidad(nombreComunidad).orElse(null);
    }

    public ChatCommunity createCommunity(ChatCommunity chatCommunity) {
        return chatCommunityRepository.save(chatCommunity);
    }

    public void deleteCommunity(Long id) {
        chatCommunityRepository.deleteById(id);
    }
}
