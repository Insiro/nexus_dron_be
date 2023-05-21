package drone_be.noticeservice.controller;

import drone_be.noticeservice.domain.Notice;
import drone_be.noticeservice.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.UUID;

@CrossOrigin("http://localhost:3000")
@RestController
public class NoticeController {

    @Autowired
    private final NoticeRepository noticeRepository;
    public NoticeController(NoticeRepository noticeRepository) { this.noticeRepository = noticeRepository;}
    @GetMapping("/api/notice")
    public List<Notice> getNotice(){return noticeRepository.findAll();}
    @GetMapping("/api/notice/{uid}")
    public Optional<Notice> getNoticeId(@PathVariable("uid") UUID uid) { return noticeRepository.findById(uid);}

    @PutMapping("/api/newNotice")
    public String createNotice(@RequestBody Notice notice){
        noticeRepository.save(notice);
        return "notice create ok";
    }

    @PostMapping("/api/notice/{uid}")
    public String setNotice(@PathVariable("uid") UUID uid, @RequestBody Notice notice){
        Optional<Notice> existingNotice = noticeRepository.findById(uid);
        if (existingNotice.isPresent()) {
            Notice updatedNotice = existingNotice.get();
            updatedNotice.setTitle(notice.getTitle());
            updatedNotice.setContent(notice.getContent());
            updatedNotice.setDate(notice.getDate());
            updatedNotice.setWriter(notice.getWriter());

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