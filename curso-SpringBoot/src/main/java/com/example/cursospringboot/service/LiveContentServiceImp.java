package com.example.cursospringboot.service;


import com.example.cursospringboot.entity.LiveContent;
import com.example.cursospringboot.repository.LiveContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LiveContentServiceImp implements LiveContentService{

    @Autowired
    private LiveContentRepository liveContentRepository;


    @Override
    public List<LiveContent> getAllLiveContents() {
        return liveContentRepository.findAll();
    }

    @Override
    public LiveContent getLiveContentById(Long id) {
        return liveContentRepository.findById(id).orElse(null);
    }

    @Override
    public LiveContent createLiveContent(LiveContent liveContent) {
        return liveContentRepository.save(liveContent);
    }

    @Override
    public LiveContent updateLiveContent(LiveContent liveContent) {
        return liveContentRepository.save(liveContent);
    }

    @Override
    public void deleteLiveContent(Long id) {
        liveContentRepository.deleteById(id);
    }

    @Override
    public List<LiveContent> getLiveContentByStartTime(LocalDateTime startTime) {

        return liveContentRepository.findByStartTime(startTime);
    }


    @Override
    public List<LiveContent> getLiveContentByEndTime(LocalDateTime endTime) {

        return liveContentRepository.findByEndTime(endTime);
    }


    @Override
    public LiveContent getCurrentLiveContent() {
        LocalDateTime now = LocalDateTime.now();
        List<LiveContent> liveContents = liveContentRepository.findActiveLiveContents(now);
        for (LiveContent liveContent : liveContents) {
            LocalDateTime startTime = liveContent.getStartTime();
            LocalDateTime endTime = liveContent.getEndTime();
            if (now.isAfter(startTime) && now.isBefore(endTime)) {
                return liveContent;
            }
        }
        return null;
    }

    @Override
    public List<LiveContent> getFutureLiveContents() {
        LocalDateTime now = LocalDateTime.now();
        return liveContentRepository.findFutureLiveContents(now);
    }


    @Override
    public boolean existsOverlappingLiveContents(LocalDateTime startTime, LocalDateTime endTime) {
        return liveContentRepository.existsOverlappingLiveContents(startTime, endTime);
    }

}
