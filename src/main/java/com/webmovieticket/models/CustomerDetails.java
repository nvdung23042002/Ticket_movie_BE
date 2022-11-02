package com.webmovieticket.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cust_id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    private String mobile;

    private String type;

    private String payment_status;

    private Double amount;

    private Double pay_amount;

    private Date payment_date;

    private String transid;





}
