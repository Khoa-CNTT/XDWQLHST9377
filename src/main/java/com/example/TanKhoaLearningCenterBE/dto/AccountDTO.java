package com.example.TanKhoaLearningCenterBE.dto;

import com.example.TanKhoaLearningCenterBE.entity.AccountEntity;
import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Data
public class AccountDTO {
    private UUID id;
    private String username;
    private String password;
    private Timestamp createdAt;
    private Timestamp modifiedAt;

    public AccountDTO(AccountEntity account){
        this.id = account.getAccountId();
        this.username = account.getUserName();
        this.password = account.getPassWord();
        this.createdAt = account.getCreateAt();
        this.modifiedAt = account.getModifiedAt();
    }
}
