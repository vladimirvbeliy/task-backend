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
import java.util.stream.Collectors;

@Service
@Slf4j
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class DataHandlingService {
    PaymantMapper mapper;
    PaymentRepository repository;

    public void handleReceivedData(PaymentListDto dtoList) {
        List<Payment> paymentsToSave = mapper.toListOfPayments(dtoList);

        String paymentIds = getPaymentIdsForLogging(paymentsToSave);
        log.info("Saving data retrieved form server PaymentIDs: {}", paymentIds);
        repository.saveAll(paymentsToSave);
    }

    private String getPaymentIdsForLogging(List<Payment> payments) {
        return payments.stream().map(Payment::getPaymentId).map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
