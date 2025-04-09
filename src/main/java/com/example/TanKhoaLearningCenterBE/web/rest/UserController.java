package com.example.TanKhoaLearningCenterBE.web.rest;

import com.example.TanKhoaLearningCenterBE.entity.AccountEntity;
import com.example.TanKhoaLearningCenterBE.repository.UserRepository;
import com.example.TanKhoaLearningCenterBE.web.rest.request.CreateUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequiredArgsConstructor
@RequestMapping("users")
public class UserController {
    private final PasswordEncoder encoder;
    private final UserRepository userRepository;

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody CreateUserRequest user){
        // this should go in a service class -> keeping it simple

        //need better error handling with custom exceptions ->

        Optional<AccountEntity> optionalUser = userRepository.findByUsername(user.getUsername());

        if (optionalUser.isEmpty()){
            userRepository.save(AccountEntity.builder()
                            .username(user.getUsername())
                            .password(encoder.encode(user.getPassword()))
                    .build());
            return ResponseEntity.ok("Success");
        }

        return ResponseEntity.badRequest().body("Failure");
    }

//    @GetMapping("/{id}")
//
//    @DeleteMapping("/{id}")
//
//    // List page users
//    @GetMapping("")
}
