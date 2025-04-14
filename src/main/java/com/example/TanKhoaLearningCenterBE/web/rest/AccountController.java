package com.example.TanKhoaLearningCenterBE.web.rest;

import com.example.TanKhoaLearningCenterBE.dto.AccountDTO;
import com.example.TanKhoaLearningCenterBE.repository.AccountRepository;
import com.example.TanKhoaLearningCenterBE.service.AccountService;
import com.example.TanKhoaLearningCenterBE.web.rest.request.CreateAccountRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountRepository accountRepository;
    private final AccountService accountService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CreateAccountRequest account){
        return accountService.create(account);
    }

    @PostMapping("/{name}")
    public ResponseEntity<List<AccountDTO>> search(@RequestParam String name){
        return accountService.search(name);
    }
}
