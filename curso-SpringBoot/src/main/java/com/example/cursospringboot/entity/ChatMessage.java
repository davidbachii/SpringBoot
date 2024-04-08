package com.example.cursospringboot.entity;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "ChatMessage")
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "message", length = 1000, nullable = false)
    private String message;

    @Column(name = "sentDate", length = 12, nullable = false)
    private LocalDate sentDate;

    @ManyToOne
    private User sentBy;

    @ManyToOne
    private ChatCommunity community;

    //Constructor
    public ChatMessage() {
    }

    //Constructor con parametros
    public ChatMessage(String message, LocalDate sentDate, User sentBy, ChatCommunity community) {
        this.message = message;
        this.sentDate = sentDate;
        this.sentBy = sentBy;
        this.community = community;
    }

    //Getters y Setters

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDate getSentDate() {
        return sentDate;
    }

    public void setSentDate(LocalDate sentDate) {
        this.sentDate = LocalDate.now();
    }

    public User getSentBy() {
        return sentBy;
    }

    public void setSentBy(User sentBy) {
        this.sentBy = sentBy;
    }

    public ChatCommunity getCommunity() {
        return community;
    }

    public void setCommunity(ChatCommunity community) {
        this.community = community;
    }
}
