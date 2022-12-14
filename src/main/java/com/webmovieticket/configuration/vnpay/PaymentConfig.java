package com.webmovieticket.configuration.vnpay;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PaymentConfig {

    public static final String IPDEFAULT = "127.0.0.1";
    public static final String VERSIONVNPAY = "2.1.0";
    public static final String COMMAND = "pay";
    public static final String ORDERTYPE = "250000";          // Mã danh mục hàng hóa.
    public static final String TMNCODE = "VW4CHF8Y";            // Mã website của merchant trên hệ thống của VNPAY. Ví dụ: 2QXUI4J4
    public static final String CURRCODE = "VND";
    public static final String LOCALEDEFAULT = "vn";
    public static final String RETURNURL = "http://w42g8.int3306.freeddns.org/test/payment/thong-tin-thanh-toan";       // THÔNG TIN THANH TOÁN
    public static final String CHECKSUM = "FEWXXWKLFFOTOINDLREISFEZVKOFHXBU";           // vnp_SecureHash
    public static final String VNPAYURL = "https://sandbox.vnpayment.vn/paymentv2/vpcpay.html";

}
