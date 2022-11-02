package com.webmovieticket.dto;

import java.util.Date;

public class CustomerDetailsDTO {
    private Long cust_id;

    private String name;

    private String email;

    private String mobile;

    private String type;

    private String payment_status;

    private Double amount;

    private Double pay_amount;

    private Date payment_date;

    private String transid;

    public Long getCust_id() {
        return cust_id;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getType() {
        return type;
    }

    public String getPayment_status() {
        return payment_status;
    }

    public Double getAmount() {
        return amount;
    }

    public Double getPay_amount() {
        return pay_amount;
    }

    public Date getPayment_date() {
        return payment_date;
    }

    public String getTransid() {
        return transid;
    }

//Setter
    public void setCust_id(Long cust_id) {
        this.cust_id = cust_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPayment_status(String payment_status) {
        this.payment_status = payment_status;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setPay_amount(Double pay_amount) {
        this.pay_amount = pay_amount;
    }

    public void setPayment_date(Date payment_date) {
        this.payment_date = payment_date;
    }

    public void setTransid(String transid) {
        this.transid = transid;
    }
}
