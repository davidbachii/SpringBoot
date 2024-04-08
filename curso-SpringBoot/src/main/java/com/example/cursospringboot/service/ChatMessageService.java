package com.example.cursospringboot.service;

import com.example.cursospringboot.entity.ChatMessage;
import com.example.cursospringboot.entity.User;

import java.util.List;

public interface ChatMessageService {

    List<ChatMessage> getAllMessages();
    ChatMessage getMessageById(Long id);
    ChatMessage createMessage(ChatMessage chatMessage);
    void deleteMessage(Long id);
    List<ChatMessage> getMessagesByUser(User user);
    List<ChatMessage> getMessagesByOtherUsers(User user);

}
