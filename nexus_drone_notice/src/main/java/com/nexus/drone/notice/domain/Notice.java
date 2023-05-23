package com.nexus.drone.notice.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@Entity
public class Notice implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uid;

    private String title;

    private String content;

    private LocalDateTime date;//ex)2023-05-22

    private String writer;

    public LocalDateTime getDate() {
        if (date != null) {
            return date;
        } else {
            // null인 경우에 대한 처리 로직 추가
            return LocalDateTime.now(); // 현재 시간을 반환하거나 다른 기본값을 설정할 수 있습니다.
        }
    }
}