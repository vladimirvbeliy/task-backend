package com.task.bank.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "payment")
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long paymentId;
    private Long opfuCode;
    private String opfuName;
    private LocalDate dateCr;
    private Long mfoFilia;
    private Long filiaNum;
    private String filiaName;
    private Integer fullSum;
    private Integer fullLines;
}
