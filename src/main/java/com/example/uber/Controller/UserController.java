package com.example.uber.Controller;


import com.example.uber.DTO.LoginDTO;
import com.example.uber.Entity.User;
import com.example.uber.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.persistence.Table;


@RestController
    @RequestMapping("/api/users")
    public class UserController {

        @Autowired
        private UserService userService;


        @PostMapping("/register")
        public ResponseEntity<User> register(@RequestBody User user) {
            User savedUser = userService.registerUser(user);
            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
        }
        @PostMapping("/login")
        public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
            try{
                User user =userService.login(loginDTO.getEmail(),loginDTO.getPassword());

            return new ResponseEntity<>("Login successful! Welcome " + user.getName(), HttpStatus.OK);
        } catch (RuntimeException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}
        }



