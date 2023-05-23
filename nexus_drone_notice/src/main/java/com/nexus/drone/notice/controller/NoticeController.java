package com.nexus.drone.notice.controller;

import com.nexus.drone.notice.domain.Notice;
import com.nexus.drone.notice.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.UUID;
import java.util.stream.Collectors;

@CrossOrigin("http://localhost:3000")
@RestController
public class NoticeController {

    @Autowired
    private final NoticeRepository noticeRepository;
    public NoticeController(NoticeRepository noticeRepository) { this.noticeRepository = noticeRepository;}
    @GetMapping("/api/notice")
    public List<Notice> getNotice(){
        List<Notice> notices = noticeRepository.findAll();

        List<Notice> sortedNotices = notices.stream()
                .filter(notice -> notice != null) // null 체크
                .sorted((n1, n2) -> n2.getDate().compareTo(n1.getDate()))
                .collect(Collectors.toList());

        return sortedNotices;
    }
    @GetMapping("/api/notice/{uid}")
    public Optional<Notice> getNoticeId(@PathVariable("uid") UUID uid) { return noticeRepository.findById(uid);}

    @PutMapping("/api/newNotice")
    public String createNotice(@RequestBody Notice notice){
        if(notice.getContent()!=null&&notice.getTitle()!=null){
            LocalDateTime currentTime = LocalDateTime.now();

            notice.setDate(currentTime);
            noticeRepository.save(notice);
            return "notice create ok";
        }else{
            return "content and title are required";
        }
    }

    @PostMapping("/api/notice/{uid}")
    public String setNotice(@PathVariable("uid") UUID uid, @RequestBody Notice notice){
        Optional<Notice> existingNotice = noticeRepository.findById(uid);
        if (existingNotice.isPresent()) {
            Notice updatedNotice = existingNotice.get();

            if(notice.getContent()==null&&notice.getTitle()==null) return "content and title are required";
            
            updatedNotice.setTitle(notice.getTitle());
            updatedNotice.setContent(notice.getContent());
            updatedNotice.setDate(existingNotice.get().getDate());//기존 시간 값 유지

            noticeRepository.save(updatedNotice);
            return "Notice updated successfully.";
        } else {
            return "Notice not found.";
        }
    }

    @DeleteMapping("/api/notice/{uid}")
    public String deleteNotice(@PathVariable("uid") UUID uid){
        Optional<Notice> existingNotice = noticeRepository.findById(uid);
        if (existingNotice.isPresent()) {
            Notice deletedNotice = existingNotice.get();

            noticeRepository.delete(deletedNotice);
            return "Notice deleted successfully.";
        } else {
            return "Notice not found.";
        }
    }
}
