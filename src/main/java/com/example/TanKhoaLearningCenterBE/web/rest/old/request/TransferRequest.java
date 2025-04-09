package com.example.TanKhoaLearningCenterBE.web.rest.old.request;

import lombok.Data;

@Data
public class TransferRequest {
    private String fromUser;
    private String toUser;
    private double amount;
}
