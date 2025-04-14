package com.example.TanKhoaLearningCenterBE.service;

import com.example.TanKhoaLearningCenterBE.dto.AccountDTO;
import com.example.TanKhoaLearningCenterBE.web.rest.request.CreateAccountRequest;
import com.example.TanKhoaLearningCenterBE.web.rest.response.PageResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AccountService {
    ResponseEntity<?> create(CreateAccountRequest request);

    ResponseEntity<?> delete(String name);

    ResponseEntity<PageResponse<AccountDTO>> getAll(Integer page, Integer size);

    ResponseEntity<List<AccountDTO>> search(String input);
}
