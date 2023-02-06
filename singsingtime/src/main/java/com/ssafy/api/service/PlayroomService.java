package com.ssafy.api.service;

import com.ssafy.db.entity.Playroom;

import java.util.List;

public interface PlayroomService {
    public List<Playroom> getPlayroom();
    public List<Playroom> getPlayroomByTitle(String keyword);
}
