package com.nexus.drone.user.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.io.Serializable;
@Data
//@Table(name="user")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@Entity
public class User implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long uuid;
//    @ColumnDefault("1")
    private int permission;
    private String ID;
    private String pwd;
//    @ColumnDefault("https://swingbrowser.userecho.com/s/cache/b5/09/b5098d61f3ef34b35311456b08123897.png")
    private String img;
}

