package com.ssafy.db.repository;

import com.ssafy.db.entity.Playroom;
import com.ssafy.db.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlayroomRepository  extends JpaRepository<Playroom, Long> {
    List<Playroom> findByTitle(String title);
<<<<<<< HEAD

    Optional<Playroom> findBySessionId(int sessionId);

=======
>>>>>>> b399807521a7873f01c59efd04bdc58eda160b08
}
