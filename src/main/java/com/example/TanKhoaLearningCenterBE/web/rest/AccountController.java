package com.example.TanKhoaLearningCenterBE.web.rest;

import com.example.TanKhoaLearningCenterBE.dto.AccountDTO;
import com.example.TanKhoaLearningCenterBE.entity.AccountEntity;
import com.example.TanKhoaLearningCenterBE.repository.AccountRepository;
import com.example.TanKhoaLearningCenterBE.service.AccountService;
import com.example.TanKhoaLearningCenterBE.web.rest.request.CreatAccountRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountRepository accountRepository;
    private final AccountService accountService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CreatAccountRequest account){
//        Optional<AccountEntity> optionalAccount = accountRepository.findByUserName(account.getUsername());
//
//        if (optionalAccount.isEmpty()){
//            accountRepository.save(AccountEntity.builder()
//                    .userName(account.getUsername())
//                    .passWord(encoder.encode(account.getPassword()))
//                    .build());
//            return ResponseEntity.ok("Success");
//        }
//
//        return ResponseEntity.badRequest().body("Failure");
        return accountService.create(account);
    }

    @PostMapping("/{name}")
    public ResponseEntity<List<AccountDTO>> search(@RequestParam String name){
        return accountService.search(name);
    }
}
