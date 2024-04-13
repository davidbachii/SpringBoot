package com.example.cursospringboot.service;

import com.example.cursospringboot.entity.ChatCommunity;
import com.example.cursospringboot.entity.ChatMessage;
import com.example.cursospringboot.entity.User;

import java.util.List;

public interface ChatMessageService {

    List<ChatMessage> getAllMessages();
    ChatMessage getMessageById(Long id);
    ChatMessage createMessage(ChatMessage chatMessage);
    void deleteMessage(Long id);
    List<ChatMessage> getMessagesByUserAndCommunity(User user, ChatCommunity community);
    List<ChatMessage> getMessagesByOtherUsersAndCommunity(User user, ChatCommunity community);

    List<ChatMessage> getMessagesByCommunity(ChatCommunity community);

    boolean isMessageSentByUserInCommunity(User user, ChatCommunity community);


}
