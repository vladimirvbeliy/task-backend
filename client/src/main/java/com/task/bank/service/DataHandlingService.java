package com.task.bank.service;

import com.task.bank.dto.PaymentListDto;
import com.task.bank.mapper.PaymantMapper;
import com.task.bank.model.Payment;
import com.task.bank.repository.PaymentRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class DataHandlingService {
    PaymantMapper mapper;
    PaymentRepository repository;

    public void handleReceivedData(PaymentListDto dtoList) {
        List<Payment> paymentsToSave = mapper.toListOfPayments(dtoList);

        log.info("Saving data retrieved form server");
        repository.saveAll(paymentsToSave);
    }
}
