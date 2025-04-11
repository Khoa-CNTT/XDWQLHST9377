package com.example.TanKhoaLearningCenterBE.service;

import com.example.TanKhoaLearningCenterBE.dto.AccountDTO;
import com.example.TanKhoaLearningCenterBE.entity.AccountEntity;
import com.example.TanKhoaLearningCenterBE.exception.AccountNotFoundException;
import com.example.TanKhoaLearningCenterBE.repository.AccountRepository;
import com.example.TanKhoaLearningCenterBE.web.rest.request.CreatAccountRequest;
import com.example.TanKhoaLearningCenterBE.web.rest.response.PageResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceImp implements AccountService{
    private final AccountRepository accountRepository;

    @Override
    public ResponseEntity<AccountDTO> create(CreatAccountRequest request) {
//        var acct = new AccountEntity();
//        acct.setUsername(request.getUsername());
//        acct.setPassword(request.getPassword());
//        var saveAcct = accountRepository.save(acct);
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(new AccountDTO(saveAcct));

        return null;
    }


    @Override
    public ResponseEntity<PageResponse<AccountDTO>> getAll(Integer page, Integer size) {
//        Pageable pageable = PageRequest.of(page, size);
//        Page<AccountEntity> accounts = accountRepository.findAll(pageable);
//        List<AccountDTO> rows = accounts.getContent().stream().map(AccountDTO::new).toList();
//        var response = new PageResponse<AccountDTO>();
//        response.setCount(accounts.getTotalElements());
//        response.setRows(rows);
//        response.setPage(page);
//        response.setSize(size);
//
//        return ResponseEntity.status(HttpStatus.OK).body(response);

        return null;
    }

    @Override
    public ResponseEntity<?> delete(String name) {
        return null;
    }

    @Override
    public ResponseEntity<List<AccountDTO>> search(String name) {
        Optional<AccountEntity> accountEntityOptional = accountRepository.findByUserNameContaining(name);
        if (!accountEntityOptional.isEmpty()){
            accountRepository.findByUserNameContaining(name);
            return ResponseEntity.ok(accountRepository.findByUserNameContaining(name).stream().map(AccountDTO::new).toList());
        }

        throw new AccountNotFoundException();
    }
}
