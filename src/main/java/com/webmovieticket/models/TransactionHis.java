package com.webmovieticket.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "transactionHis")
public class TransactionHis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer amount;
    private String bankCode;
    private String bankTranNo;
    private String cardType;
    private String payDate;
    private String orderInfo;
    private String transactionNo;
    private String responseCode;
    private String transactionStatus;
    private String txnRef;
    private String secureHashType;
    private String secureHash;
    private Long userId;
    private String tickets;

}
