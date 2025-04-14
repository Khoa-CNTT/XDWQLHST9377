package com.example.TanKhoaLearningCenterBE.service;

import com.example.TanKhoaLearningCenterBE.dto.RoleDTO;
import com.example.TanKhoaLearningCenterBE.entity.RoleEntity;
import com.example.TanKhoaLearningCenterBE.exception.RoleNameAlreadyExistException;
import com.example.TanKhoaLearningCenterBE.repository.RoleRepository;
import com.example.TanKhoaLearningCenterBE.web.rest.request.CreateRoleRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoleServiceImp implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public ResponseEntity<?> create(CreateRoleRequest createRoleRequest) {
        Optional<RoleEntity> existingRoleName = roleRepository.findByRoleName(createRoleRequest.getRolename());

        if (existingRoleName.isPresent()) {
            throw new RoleNameAlreadyExistException(createRoleRequest.getRolename());
        }

        var roleN = new RoleEntity();
        roleN.setRoleName(createRoleRequest.getRolename());
        var saveRole = roleRepository.save(roleN);

        return ResponseEntity.status(HttpStatus.CREATED).body(new RoleDTO(saveRole));
    }
}
