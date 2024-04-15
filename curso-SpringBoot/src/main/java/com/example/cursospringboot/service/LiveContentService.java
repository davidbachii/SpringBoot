package com.example.cursospringboot.service;

import com.example.cursospringboot.entity.LiveContent;

import java.time.LocalDateTime;
import java.util.List;

public interface LiveContentService {

    public List<LiveContent> getAllLiveContents();

    public LiveContent getLiveContentById(Long id);

    public LiveContent createLiveContent(LiveContent liveContent);

    public LiveContent updateLiveContent(LiveContent liveContent);

    public void deleteLiveContent(Long id);

    public List<LiveContent> getLiveContentByStartTime(LocalDateTime startTime);

    public List<LiveContent> getLiveContentByEndTime(LocalDateTime endTime);
}
