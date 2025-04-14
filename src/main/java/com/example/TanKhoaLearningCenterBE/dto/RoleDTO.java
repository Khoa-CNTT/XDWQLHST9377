package com.example.TanKhoaLearningCenterBE.dto;

import com.example.TanKhoaLearningCenterBE.entity.RoleEntity;
import lombok.Data;

import java.util.UUID;

@Data
public class RoleDTO {
    private UUID id;
    private String name;

    public RoleDTO(RoleEntity roleEntity){
        this.id = roleEntity.getRoleId();
        this.name = roleEntity.getRoleName();
    }
}
