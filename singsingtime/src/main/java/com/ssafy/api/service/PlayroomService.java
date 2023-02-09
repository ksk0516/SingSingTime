package com.ssafy.api.service;

<<<<<<< HEAD
import com.ssafy.api.request.PlayroomCreateReq;
import com.ssafy.api.request.PlayroomStatusReq;
import com.ssafy.api.response.PlayroomStatusRes;
import com.ssafy.db.entity.Playroom;
import com.ssafy.db.entity.Song;
=======
import com.ssafy.db.entity.Playroom;
>>>>>>> b399807521a7873f01c59efd04bdc58eda160b08

import java.util.List;

public interface PlayroomService {
    public List<Playroom> getPlayroom();
    public List<Playroom> getPlayroomByTitle(String keyword);
<<<<<<< HEAD

    public List<Song> getChampionSongList(int sessionId);

    public void createRoom(PlayroomCreateReq playroomCreateReq);

    void startSong(PlayroomStatusReq playroomStatusReq);

    public PlayroomStatusRes endSong(PlayroomStatusReq playroomStatusReq);
}

=======
}
>>>>>>> b399807521a7873f01c59efd04bdc58eda160b08
