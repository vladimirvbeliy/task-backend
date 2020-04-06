package com.task.bank.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@XmlRootElement(name = "paymentlists")
@XmlAccessorType(XmlAccessType.FIELD)
public class PaymentListDto {

    @XmlElement(name = "payments")
    private List<PaymentDto> payments = null;
}
