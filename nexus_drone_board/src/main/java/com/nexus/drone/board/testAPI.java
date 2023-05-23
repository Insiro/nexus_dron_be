package com.nexus.drone.board;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testAPI {
    
    @PostMapping("/test/check")
    public String test(){
        return "clear";
    }

}
