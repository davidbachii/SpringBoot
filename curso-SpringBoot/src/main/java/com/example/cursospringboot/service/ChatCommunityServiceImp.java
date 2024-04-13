package com.example.cursospringboot.service;

import com.example.cursospringboot.entity.ChatCommunity;
import com.example.cursospringboot.repository.ChatCommunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatCommunityServiceImp implements ChatCommunityService{

    @Autowired
    private ChatCommunityRepository chatCommunityRepository;


    @Override
    public List<ChatCommunity> getAllCommunities() {
        return chatCommunityRepository.findAll();
    }

    @Override
    public ChatCommunity getCommunityById(Long id) {
        return chatCommunityRepository.findById(id).orElse(null);
    }

    @Override
    public ChatCommunity getCommunityByName(String nombreComunidad) {
        return chatCommunityRepository.findByNombreComunidad(nombreComunidad);
    }

    @Override
    public ChatCommunity createCommunity(ChatCommunity chatCommunity) {
        return chatCommunityRepository.save(chatCommunity);
    }

    @Override
    public void deleteCommunity(Long id) {
        chatCommunityRepository.deleteById(id);
    }
}
