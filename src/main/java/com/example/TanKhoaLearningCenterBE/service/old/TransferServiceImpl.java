package com.example.TanKhoaLearningCenterBE.service.old;

import com.example.TanKhoaLearningCenterBE.entity.old.BankEntity;
import com.example.TanKhoaLearningCenterBE.repository.old.BankAccountRepository;
import com.example.TanKhoaLearningCenterBE.web.rest.old.request.TransferRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
public class TransferServiceImpl implements TransferService {
    private final BankAccountRepository bankAccountRepository;

    public TransferServiceImpl(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    @Transactional
    public ResponseEntity<?> execute(TransferRequest transferRequest) {
        log.info("*** request: {}", transferRequest);
        Optional<BankEntity> fromAccount = bankAccountRepository.findByName(transferRequest.getFromUser());
        Optional<BankEntity> toAccount = bankAccountRepository.findByName(transferRequest.getToUser());
        if (fromAccount.isEmpty() || toAccount.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        BankEntity from = fromAccount.get();
        BankEntity to = toAccount.get();

        //add & deduct
        to.setBalance(to.getBalance() + transferRequest.getAmount());
        bankAccountRepository.save(to);
        //At this point -> have added new money but not checked if enough to tranfer
        log.info("*** After adding, before deducting: ");
        log.info("BankEntity: {}", bankAccountRepository.findByName(to.getName())); //This would be better as a logging statement
        from.setBalance(from.getBalance() - transferRequest.getAmount());
        bankAccountRepository.save(from);

        return ResponseEntity.ok("Success");
    }
}
