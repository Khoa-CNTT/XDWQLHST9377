package com.example.TanKhoaLearningCenterBE.service;

import com.example.TanKhoaLearningCenterBE.dto.ParentDTO;
import com.example.TanKhoaLearningCenterBE.web.rest.request.CreateParentRequest;
import com.example.TanKhoaLearningCenterBE.web.rest.response.PageResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface ParentService {
    ResponseEntity<ParentDTO> create(CreateParentRequest request);

    ResponseEntity<PageResponse<ParentDTO>> getAll(Integer page, Integer size);

    ResponseEntity<?> delete(UUID id);

    ResponseEntity<List<ParentDTO>> search(String name);
}
