package com.example.cursospringboot.service;

import com.example.cursospringboot.entity.ChatCommunity;

import java.util.List;
import java.util.Optional;

public interface ChatCommunityService {

    List<ChatCommunity> getAllCommunities();
    ChatCommunity getCommunityById(Long id);

    ChatCommunity getCommunityByName(String nombreComunidad);
    ChatCommunity createCommunity(ChatCommunity chatCommunity);
    void deleteCommunity(Long id);



}
