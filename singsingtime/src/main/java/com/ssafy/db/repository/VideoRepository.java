package com.ssafy.db.repository;

import com.ssafy.db.entity.Diary;
import com.ssafy.db.entity.Video;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.List;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {
    List<Video> findByUserIdOrderByCreatedDateAsc(String userId);

//    @Query("select * from Video"
//     +" WHERE created_at BETWEEN %:year%-%:monrh%-%:day%T00:00:00.000000 AND %:year%-%:monrh%-%:day%T23:59:59.9999999 ;"
//    )
//    List<Video> findHighlightList(@Param("year") String year,@Param("month") String month,@Param("day") String day);
//    @Query("SELECT * FROM Video WHERE createdAt BETWEEN DATE_ADD (NOW(), INTERVAL -1 DAY) AND NOW();")
    @Query("SELECT v FROM Video v WHERE v.CreatedDate BETWEEN DATE_ADD (NOW(), INTERVAL -1 DAY) and NOW();")
    List<Video> findHighlightList();

//    @Query("SELECT * FROM Video WHERE createdAt BETWEEN DATE_ADD (NOW(), INTERVAL -1 WEEK) AND NOW();")
//    List<Video> findFameVideoList();
    
}
