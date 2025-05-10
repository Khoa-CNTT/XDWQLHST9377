package com.example.TanKhoaLearningCenterBE.dto;

import com.example.TanKhoaLearningCenterBE.entity.BillEntity;
import lombok.Data;

import java.util.UUID;

@Data
public class BillDTO {
    private UUID id;
    private String content;
    private String status;

    public BillDTO(BillEntity billEntity) {
        this.id = billEntity.getBillId();
        this.content = billEntity.getBillContent();
        if (billEntity.getBillStatus() != null) {
            this.status = billEntity.getBillStatus().toString();
        }
    }
}
