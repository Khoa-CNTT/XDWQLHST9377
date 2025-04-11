package com.example.TanKhoaLearningCenterBE.service;

import com.example.TanKhoaLearningCenterBE.dto.AccountDTO;
import com.example.TanKhoaLearningCenterBE.entity.AccountEntity;
import com.example.TanKhoaLearningCenterBE.exception.AccountNotFoundException;
import com.example.TanKhoaLearningCenterBE.exception.UserNameAlreadyExistException;
import com.example.TanKhoaLearningCenterBE.repository.AccountRepository;
import com.example.TanKhoaLearningCenterBE.web.rest.request.CreatAccountRequest;
import com.example.TanKhoaLearningCenterBE.web.rest.response.PageResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceImp implements AccountService{
    private final AccountRepository accountRepository;

    @Override
    public ResponseEntity<AccountDTO> create(CreatAccountRequest request) {
        Optional<AccountEntity> existingAccount = accountRepository.findByUserName(request.getUsername());

        if (existingAccount.isPresent()) {
            throw new UserNameAlreadyExistException(request.getUsername());
        }

        var acct = new AccountEntity();
        acct.setUserName(request.getUsername());
        acct.setPassWord(request.getPassword());
        var saveAcct = accountRepository.save(acct);

        return ResponseEntity.status(HttpStatus.CREATED).body(new AccountDTO(saveAcct));
    }


    @Override
    public ResponseEntity<PageResponse<AccountDTO>> getAll(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<AccountEntity> accounts = accountRepository.findAll(pageable);
        List<AccountDTO> rows = accounts.getContent().stream().map(AccountDTO::new).toList();
        var response = new PageResponse<AccountDTO>();
        response.setCount(accounts.getTotalElements());
        response.setRows(rows);
        response.setPage(page);
        response.setSize(size);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    public ResponseEntity<?> delete(String name) {
        Optional<AccountEntity> optionalAccount = accountRepository.findByUserName(name);
        if (optionalAccount.isPresent()){
            accountRepository.delete(optionalAccount.get());
            return ResponseEntity.ok("Success");
        }
        throw new AccountNotFoundException();
    }

    @Override
    public ResponseEntity<List<AccountDTO>> search(String name) {
        Optional<AccountEntity> accountEntityOptional = accountRepository.findByUserName(name);
        if (accountEntityOptional.isPresent()){
            accountRepository.findByUserName(name);
            return ResponseEntity.ok(accountRepository.findByUserName(name).stream().map(AccountDTO::new).toList());
        }
        throw new AccountNotFoundException();
    }
}
