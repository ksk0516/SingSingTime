package com.ssafy.api.controller;

import com.ssafy.api.service.PlayroomService;
import com.ssafy.db.entity.Playroom;
import com.ssafy.db.entity.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playrooms")
public class PlayroomController {

    @Autowired
    PlayroomService playroomService;

    // 방 목록 조회
    @GetMapping("/")
    public ResponseEntity<List<Playroom>> getRoomInfo() {
        List<Playroom> list = playroomService.getPlayroom();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    // 노래 제목으로 방 목록 조회
    @GetMapping("/{keyword}")
    public ResponseEntity<List<Playroom>> getRoomInfoByKeyword(@PathVariable String keyword) {
        List<Playroom> list = playroomService.getPlayroomByTitle(keyword);
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<List<Playroom>> createRoom() {
        List<Playroom> list = playroomService.getPlayroom();
        return new ResponseEntity(list, HttpStatus.OK);
    }

}
