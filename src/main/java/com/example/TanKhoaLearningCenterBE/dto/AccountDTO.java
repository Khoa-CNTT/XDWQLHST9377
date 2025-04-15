package com.example.TanKhoaLearningCenterBE.dto;

import com.example.TanKhoaLearningCenterBE.entity.AccountEntity;
import com.example.TanKhoaLearningCenterBE.utils.user.Role;
import lombok.Data;

import java.util.UUID;

@Data
public class AccountDTO {
    private UUID id;
    private String username;
    private String password;
    private Role role;

    public AccountDTO(AccountEntity account){
        this.id = account.getAccountId();
        this.username = account.getUsername();
        this.password = account.getPassword();
        this.role = account.getRole();
    }
}
