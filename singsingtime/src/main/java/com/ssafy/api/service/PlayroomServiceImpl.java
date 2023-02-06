package com.ssafy.api.service;

import com.ssafy.db.entity.Playroom;
import com.ssafy.db.repository.PlayroomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayroomServiceImpl implements PlayroomService{

    private final PlayroomRepository playroomRepository;

    @Override
    public List<Playroom> getPlayroom() {
        List<Playroom> list = playroomRepository.findAll();
        return list;
    }

    @Override
    public List<Playroom> getPlayroomByTitle(String keyword) {
        List<Playroom> list = playroomRepository.findByTitle(keyword);
        return list;
    }
}
