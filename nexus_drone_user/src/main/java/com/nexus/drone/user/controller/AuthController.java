package com.nexus.drone.user.controller;

import com.nexus.drone.user.domain.User;
import com.nexus.drone.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
public class AuthController {
    @Autowired
    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/api/auth")
    public ResponseEntity<String> login(@RequestBody User user) {
        if (userRepository.findByID(user.getID()) == null) {
            //아이디가 없을때
            return
                    new ResponseEntity<>("ID_not_Exist", HttpStatus.NOT_FOUND);
        } else {
            if (!userRepository.findByID(user.getID()).getPwd().equals(user.getPwd()))
                return
                        new ResponseEntity<>("pwd_wrong", HttpStatus.NOT_ACCEPTABLE);

                //비밀번호 없을때
            else {
                String url = "http://localhost:18010/auth/getToken";
                RestTemplate restTemplate = new RestTemplate();
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                User user1 = userRepository.findByID(user.getID());
                HashMap<String, String> map = new HashMap<>();
                map.put("UUID", String.valueOf(user1.getUuid()));
                map.put("Role", String.valueOf(user1.getPermission()));
                HttpEntity<HashMap<String, String>> request =
                        new HttpEntity<>(map, headers);
                return restTemplate.postForEntity(url, request, String.class);

            }//통과
        }
    }
    
    @PostMapping("/api/auth/register")
    public int register(@RequestBody User user) {
        if (userRepository.findByID(user.getID()) != null)
            return 0;
        else {
            userRepository.save(user);
            return 1;
        }
    }

    @PutMapping("api/user/{uuid}")
    public User changeInfo(@PathVariable("uuid") Long uuid, @RequestBody User user) {
        User user1 = userRepository.findById(uuid).get();
        user1.setID(user.getID());
        user1.setPwd(user.getPwd());
        if (user.getImg() != null)
            user1.setImg(user.getImg());
        userRepository.save(user1);
        return user1;
    }

    @GetMapping("/api/user/{uuid}")
    public User userinfo(@PathVariable("uuid") Long uuid) {
        return userRepository.findById(uuid).get();
    }

    @GetMapping("/api/user")
    public List<User> AllUser() {
        return userRepository.findAll();
    }
}
