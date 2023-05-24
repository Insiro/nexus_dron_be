package com.nexus.drone.auth.AuthController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nexus.drone.auth.Service.AuthService;

import lombok.RequiredArgsConstructor;



@RestController
@RequiredArgsConstructor
public class RefreshController {
    
    private final AuthService authService;

    @PostMapping("/auth/refresh")
    public ResponseEntity<String> validateRefreshToken(@RequestBody HashMap<String, String> bodyJson){

        Map<String,String> map = authService.validateRefreshToken(bodyJson.get("refreshToken"));
        
        if(map.get("status").equals("402")){
            RefreshApiResponseMessage refreshApiResponseMessage = new RefreshApiResponseMessage(map);
            return new ResponseEntity<String>(refreshApiResponseMessage.toString(),HttpStatus.UNAUTHORIZED);
        }

        RefreshApiResponseMessage refreshApiResponseMessage = new RefreshApiResponseMessage(map);
        return new ResponseEntity<String>(refreshApiResponseMessage.toString(),HttpStatus.OK);
    }

    @PostMapping("/auth/getToken")
    public ResponseEntity<String> makeToken(@RequestBody HashMap<String, String> bodyJson){

        Map<String,String> map = authService.makeToken(bodyJson.get("UUID"),bodyJson.get("Role"));
        
        if(map.get("status").equals("402")){
            RefreshApiResponseMessage refreshApiResponseMessage = new RefreshApiResponseMessage(map);
            return new ResponseEntity<String>(refreshApiResponseMessage.toString(),HttpStatus.UNAUTHORIZED);
        }

        RefreshApiResponseMessage refreshApiResponseMessage = new RefreshApiResponseMessage(map);
        return new ResponseEntity<String>(refreshApiResponseMessage.toString(),HttpStatus.OK);
    }
}
