package com.example.cursospringboot.service;

import com.example.cursospringboot.entity.ChatMessage;
import com.example.cursospringboot.entity.User;
import com.example.cursospringboot.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatMessageServiceImp {

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    public List<ChatMessage> getAllMessages() {
        return chatMessageRepository.findAll();
    }

    public ChatMessage getMessageById(Long id) {
        return chatMessageRepository.findById(id).orElse(null);
    }

    public ChatMessage createMessage(ChatMessage chatMessage) {
        return chatMessageRepository.save(chatMessage);
    }

    public void deleteMessage(Long id) {
        chatMessageRepository.deleteById(id);
    }

    public List<ChatMessage> getMessagesByUser(User user) {
        return chatMessageRepository.findBySentBy(user);
    }

    public List<ChatMessage> getMessagesByOtherUsers(User user) {
        return chatMessageRepository.findBySentByNot(user);
    }
}
