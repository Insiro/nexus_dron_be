package com.nexus.drone.auth.Token;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Getter
@Table(name = "T_REFRESHTOKEN")
@NoArgsConstructor
@AllArgsConstructor
public class RefreshToken {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REFRESHTOKEN_ID", nullable = false)
    private Long refreshTokenId;

    @Column(name = "REFRESHTOKEN", nullable = false)
    private String refreshToken;

    @Column(name = "KEY_UUID", nullable = false)
    private String UUID;
}
