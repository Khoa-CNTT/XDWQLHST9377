package com.example.TanKhoaLearningCenterBE.web.rest;

import com.example.TanKhoaLearningCenterBE.dto.AccountDTO;
import com.example.TanKhoaLearningCenterBE.service.AccountService;
import com.example.TanKhoaLearningCenterBE.web.rest.request.CreateAccountRequest;
import com.example.TanKhoaLearningCenterBE.web.rest.response.PageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@PreAuthorize("hasRole('ADMIN')")
@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CreateAccountRequest account) {
        return accountService.create(account);
    }

    @GetMapping("/search")
    public ResponseEntity<Optional<AccountDTO>> search(@RequestParam String name) {
        return accountService.search(name);
    }

    @GetMapping("/listacc")
    public ResponseEntity<PageResponse<AccountDTO>> getAll(@RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                                                           @RequestParam(value = "size", required = false, defaultValue = "10") Integer size) {
        return accountService.getAll(page, size);
    }
}
