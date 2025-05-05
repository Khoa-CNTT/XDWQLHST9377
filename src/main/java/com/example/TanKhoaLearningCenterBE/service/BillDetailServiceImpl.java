package com.example.TanKhoaLearningCenterBE.service;

import com.example.TanKhoaLearningCenterBE.dto.BillDetailDTO;
import com.example.TanKhoaLearningCenterBE.entity.BillDetailEntity;
import com.example.TanKhoaLearningCenterBE.entity.BillEntity;
import com.example.TanKhoaLearningCenterBE.entity.ParentEntity;
import com.example.TanKhoaLearningCenterBE.entity.StudentEntity;
import com.example.TanKhoaLearningCenterBE.exception.ParentNotFoundException;
import com.example.TanKhoaLearningCenterBE.exception.StudentNotFoundException;
import com.example.TanKhoaLearningCenterBE.repository.BillDetailRepository;
import com.example.TanKhoaLearningCenterBE.repository.BillRepository;
import com.example.TanKhoaLearningCenterBE.repository.ParentRepository;
import com.example.TanKhoaLearningCenterBE.repository.StudentRepository;
import com.example.TanKhoaLearningCenterBE.web.rest.request.UpdateBillDetailsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BillDetailServiceImpl implements BillDetailService {
    private final BillDetailRepository billDetailRepository;
    private final BillRepository billRepository;
    private final StudentRepository studentRepository;
    private final ParentRepository parentRepository;

    @Override
    public ResponseEntity<BillDetailDTO> update(UUID id, UpdateBillDetailsRequest request) {
        BillEntity bill = billRepository.findById(id).orElseThrow(() -> new RuntimeException("Bill not found"));

        if (bill.getBillDetailEntity() != null) {
            return ResponseEntity.badRequest().build();
        }

        StudentEntity student = studentRepository.findById(request.getStudentId()).orElseThrow(StudentNotFoundException::new);
        ParentEntity parent = parentRepository.findById(request.getParentId()).orElseThrow(ParentNotFoundException::new);

        BillDetailEntity billDetail = new BillDetailEntity();
        billDetail.setBill(bill);
        billDetail.setDescription(request.getDescription());
        billDetail.setAmount(request.getAmount());
        billDetail.setCurrency(request.getCurrency());
        billDetail.setPaymentStatus(bill.getBillStatus().toString());
        billDetail.setStudent(student);
        billDetail.setParent(parent);

        BillDetailEntity saved = billDetailRepository.save(billDetail);

        return ResponseEntity.status(HttpStatus.CREATED).body(new BillDetailDTO(saved));
    }
}
