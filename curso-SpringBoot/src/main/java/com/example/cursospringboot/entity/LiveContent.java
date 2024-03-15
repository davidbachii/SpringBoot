package com.example.cursospringboot.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "LiveContent")
public class LiveContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "startTime",  nullable = false, length = 20)
    private LocalDateTime startTime;

    @Column(name = "endTime",  nullable = false, length = 20)
    private LocalDateTime endTime;

    @Column(name = "type", nullable = false, length = 50)
    private String type;


    //Constructor
    public LiveContent() {
    }

    //Constructor con parametros
    public LiveContent(LocalDateTime startTime, LocalDateTime endTime, String type) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.type = type;
    }

    //Getters y Setters


    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
