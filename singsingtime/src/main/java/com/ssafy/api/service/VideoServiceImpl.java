package com.ssafy.api.service;

import com.ssafy.api.request.VideoRegisterPostReq;
import com.ssafy.api.request.VideoUpdatePatchReq;
import com.ssafy.db.entity.User;
import com.ssafy.db.entity.Video;
import com.ssafy.db.repository.UserRepository;
import com.ssafy.db.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class VideoServiceImpl implements VideoService{
    @Autowired
    private final VideoRepository videoRepository;

    @Autowired
    private UserRepository userRepository;
    @Override
    public List<Video> getAllVideo() {
        return videoRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Override
    public List<Video> searchVideo(String keyword) {
        return videoRepository.findByTitleContains(keyword);
    }

    @Override
    public void updateVideo(MultipartFile file, VideoUpdatePatchReq videoReq, String userId) throws IOException {
        Video video = videoRepository.getVideoById(videoReq.getVideoId());
        Optional<User> user = userRepository.findByUserId(userId);
        video.setUser(user.orElseThrow(()-> new NoSuchElementException()));
        video.setTitle(videoReq.getTitle());
        video.setDescription(videoReq.getContext());
        if(!file.isEmpty()) {
            String storedFileName = s3Uploader.upload(file,"images");
            video.setUrl(storedFileName);
        }
        videoRepository.save(video);
    }

    @Autowired
    private S3Uploader s3Uploader;

    public VideoServiceImpl(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @Override @Transactional
    public void uploadVideo(MultipartFile file, VideoRegisterPostReq videoReq, String userId) throws IOException {
        Video video = new Video();
        Optional<User> user = userRepository.findByUserId(userId);
        video.setUser(user.orElseThrow(()-> new NoSuchElementException()));
        video.setTitle(videoReq.getTitle());
        video.setDescription(videoReq.getContext());
        if(!file.isEmpty()) {
            String storedFileName = s3Uploader.upload(file,"images");
            video.setUrl(storedFileName);
        }
        videoRepository.save(video);
    }
}