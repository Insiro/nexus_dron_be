package com.nexus.drone.auth.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexus.drone.auth.JWT.JwtUtil;
import com.nexus.drone.auth.Token.RefreshToken;
import com.nexus.drone.auth.repo.RefreshTokenRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    
    @Autowired
    private JwtUtil jwtUtil;
    private final RefreshTokenRepository refreshTokenRepository;

    @Transactional
    public Map<String,String> makeToken(String UUID,String role){

        Map<String,Object> user = new HashMap<>();

        user.put("UUID", UUID);
        user.put("Role", role);

        String AccessKey = jwtUtil.createAccessToken(user);
        String RefreshKey = jwtUtil.createRefreshToken(user);

        RefreshToken refreshToken = RefreshToken.builder().UUID(UUID).refreshToken(RefreshKey).build();
        if(refreshTokenRepository.existsByUUID(UUID)){
            refreshTokenRepository.deleteByUUID(UUID);
        }
        refreshTokenRepository.save(refreshToken);

        Map<String, String> map = new HashMap<>();
        
        map.put("status", "200");
        map.put("AccessKey", AccessKey);
        map.put("RefreshKey", RefreshKey);
        map.put("message", "AccessKey, RefreshKey 생성완료");

        return map;
    }



    public Optional<RefreshToken> getRefreshToken(String refreshToken){
        return refreshTokenRepository.findByRefreshToken(refreshToken);
    }
    
    public Map<String,String> validateRefreshToken(String refreshToken){

        RefreshToken refreshToken1 = getRefreshToken(refreshToken).get();

        boolean RefreshStatus = jwtUtil.isValid(refreshToken1.getRefreshToken());
        
        return createRefreshJson(RefreshStatus,refreshToken);

    }

    public Map<String, String> createRefreshJson(boolean RefreshTokenStatus,String refreshToken){

        Map<String, String> map = new HashMap<>();
        if(!RefreshTokenStatus){

            map.put("errortype", "Forbidden");
            map.put("status", "402");
            map.put("message", "Refresh 토큰이 만료되었습니다. 로그인이 필요합니다.");


            return map;
        }
        //기존에 존재하는 accessToken 제거

        Map<String,Object> user = jwtUtil.getUserFromToken(refreshToken);

        String createdAccessToken = jwtUtil.createAccessToken(user);

        map.put("status", "200");
        map.put("message", "Refresh 토큰을 통한 Access Token 생성이 완료되었습니다.");
        map.put("accessToken", createdAccessToken);

        return map;

    }

}
