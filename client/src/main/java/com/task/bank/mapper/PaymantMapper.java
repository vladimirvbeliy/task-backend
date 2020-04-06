package com.task.bank.mapper;

import com.task.bank.dto.PaymentDto;
import com.task.bank.dto.PaymentListDto;
import com.task.bank.model.Payment;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymantMapper {

    public List<Payment> toListOfPayments(PaymentListDto paymentListDto) {
       return paymentListDto.getPayments().stream().map(this::toPayment).collect(Collectors.toList());
    }

    private Payment toPayment(PaymentDto paymentDto) {
        Payment payment = new Payment();
        payment.setPaymentId(paymentDto.getId());;
        payment.setOpfuCode(paymentDto.getOpfuCode());
        payment.setOpfuName(paymentDto.getOpfuName());
        payment.setDateCr(parseDate(paymentDto.getDateCr()));
        payment.setMfoFilia(paymentDto.getMfoFilia());
        payment.setFiliaNum(paymentDto.getFiliaNum());
        payment.setFiliaName(paymentDto.getFiliaName());
        payment.setFullSum(paymentDto.getFullSum());
        payment.setFullLines(paymentDto.getFullLines());
        return payment;
    }

    private LocalDate parseDate(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        return LocalDate.parse(dateString, formatter);
    }
}
