package com.example.TanKhoaLearningCenterBE.service;

import com.example.TanKhoaLearningCenterBE.dto.ParentDTO;
import com.example.TanKhoaLearningCenterBE.entity.ParentEntity;
import com.example.TanKhoaLearningCenterBE.repository.ParentRepository;
import com.example.TanKhoaLearningCenterBE.web.rest.request.CreateParentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParentServiceImpl implements ParentService {
    private final ParentRepository parentRepository;

    @Override
    public ResponseEntity<ParentDTO> create(CreateParentRequest request) {
        var par = new ParentEntity();

        par.setParentName(request.getName());
        par.setParPhoneNumber(request.getPhoneNumber());
        par.setParEmail(request.getEmail());
        var savePar = parentRepository.save(par);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ParentDTO(savePar));
    }
}
