package com.nexus.drone.auth.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nexus.drone.auth.Token.RefreshToken;
import java.util.Optional;


public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long>{
    Optional<RefreshToken> findByRefreshToken(String refreshToken);

    boolean existsByUUID(String UUID);

    void deleteByUUID(String UUID);
}
