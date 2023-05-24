package com.nexus.drone.user.controller;

import com.nexus.drone.user.Token.Token;
import com.nexus.drone.user.TokenServiceFeignClient;
import com.nexus.drone.user.domain.User;
import com.nexus.drone.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
public class AuthController {
    @Autowired
    private final UserRepository userRepository;
    TokenServiceFeignClient tokenServiceFeignClient;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/api/auth")
    public ResponseEntity<Token> login(@RequestBody User user) {
        if (userRepository.findByID(user.getID()) == null) {
            //아이디가 없을때
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            if (!userRepository.findByID(user.getID()).getPwd().equals(user.getPwd()))
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            //비밀번호 없을때
            else
                return new ResponseEntity<>(tokenServiceFeignClient.getToken(), HttpStatus.OK);
            //통과
        }
    }
    @GetMapping("/api/auth/{ID}")
    public User logininfo(@PathVariable("ID") String ID){
        return userRepository.findByID(ID);
    }
    @PostMapping("/api/auth/register")
    public int register(@RequestBody User user){
        if(userRepository.findByID(user.getID())!=null)
            return 0;
        else{
            userRepository.save(user);
            return 1;
        }
    }
    @PutMapping("api/user/{uuid}")
    public User changeInfo(@PathVariable("uuid") Long uuid,@RequestBody User user){
        User user1=userRepository.findById(uuid).get();
        user1.setID(user.getID());
        user1.setPwd(user.getPwd());
        if(user.getImg()!=null)
            user1.setImg(user.getImg());
        userRepository.save(user1);
        return user1;
    }
    @GetMapping("/api/user/{uuid}")
    public User userinfo(@PathVariable("uuid") Long uuid){
        return userRepository.findById(uuid).get();
    }
    @GetMapping("/api/user")
    public List<User> AllUser(){
        return userRepository.findAll();
    }
}
