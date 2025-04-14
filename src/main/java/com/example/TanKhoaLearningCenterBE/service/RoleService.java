package com.example.TanKhoaLearningCenterBE.service;

import com.example.TanKhoaLearningCenterBE.web.rest.request.CreateRoleRequest;
import org.springframework.http.ResponseEntity;

public interface RoleService {
    ResponseEntity<?> create(CreateRoleRequest  createRoleRequest);
}
