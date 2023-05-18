package gcu.backend.user.controller;

import gcu.backend.user.domain.User;
import gcu.backend.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public int login(@RequestBody User user) {
        if (userRepository.findByID(user.getID()) == null) {
            //아이디가 없을때
            return 0;
        } else {
            if (!userRepository.findByID(user.getID()).getPwd().equals(user.getPwd()))
                return 2;//비밀번호 없을때
            else return 1;//통과
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
    @PutMapping("api/user/{ID}")
    public int changeInfo(@PathVariable("ID") String ID, User user){
        userRepository.save(user);
        return 1;
    }
    @GetMapping("/api/user/{ID}")
    public User userinfo(@PathVariable("ID") String ID){
        return userRepository.findByID(ID);
    }
    @GetMapping("/api/user")
    public List<User> AllUser(){
        return userRepository.findAll();
    }
}
