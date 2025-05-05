package com.example.TanKhoaLearningCenterBE.service;

import com.example.TanKhoaLearningCenterBE.dto.BillDTO;
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
import com.example.TanKhoaLearningCenterBE.web.rest.request.CreateBillRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BillServiceImpl implements BillService {
    private final BillRepository billRepository;
    private final BillDetailRepository billDetailRepository;
    private final StudentRepository studentRepository;
    private final ParentRepository parentRepository;

    @Override
    public ResponseEntity<BillDTO> create(CreateBillRequest request) {
        var billd = new BillEntity();
        billd.setBillContent(request.getContent());
        billd.setBillStatus(request.getStatus());
        var saveBilld = billRepository.save(billd);

        var billDetail =  new BillDetailEntity();
        billDetail.setBill(billd);
        billDetail.setDescription("");
        billDetail.setAmount(0.0);
        billDetail.setCurrency("VND");
        billDetail.setPaymentStatus(request.getStatus().toString());

        billDetailRepository.save(billDetail);

        return ResponseEntity.status(HttpStatus.CREATED).body(new BillDTO(saveBilld));
    }
}
