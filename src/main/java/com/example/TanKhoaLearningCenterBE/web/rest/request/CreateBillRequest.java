package com.example.TanKhoaLearningCenterBE.web.rest.request;

import com.example.TanKhoaLearningCenterBE.utils.bill.BillStatus;
import lombok.Data;

import java.util.UUID;

@Data
public class CreateBillRequest {
    private String content;
    private BillStatus status;
}
