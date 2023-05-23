package com.nexus.drone.notice.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
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

    private String date;//ex)2023-05-22

    private String writer;
}