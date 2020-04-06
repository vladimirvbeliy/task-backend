package com.task.bank.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement(name = "payments")
@XmlAccessorType(XmlAccessType.FIELD)
public class PaymentDto {
    private Long id;
    @XmlElement(name = "opfu_code")
    private Long opfuCode;
    @XmlElement(name = "opfu_name")
    private String opfuName;
    @XmlElement(name = "date_cr")
    private String dateCr;
    @XmlElement(name = "MFO_filia")
    private Long mfoFilia;
    @XmlElement(name = "filia_num")
    private Long filiaNum;
    @XmlElement(name = "filia_name")
    private String filiaName;
    @XmlElement(name = "full_sum")
    private Integer fullSum;
    @XmlElement(name = "full_lines")
    private Integer fullLines;
}
