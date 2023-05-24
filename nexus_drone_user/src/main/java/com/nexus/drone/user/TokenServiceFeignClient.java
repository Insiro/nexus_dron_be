package com.nexus.drone.user;

import com.nexus.drone.user.Token.Token;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("nexus_drone_auth")
public interface TokenServiceFeignClient {
    @GetMapping(value = "/auth/getToken", consumes = "application/json")
    Token getToken();
}
