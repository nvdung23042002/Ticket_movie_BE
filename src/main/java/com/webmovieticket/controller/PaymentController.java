package com.webmovieticket.controller;

import com.webmovieticket.configuration.vnpay.Config;
import com.webmovieticket.configuration.vnpay.PaymentConfig;
import com.webmovieticket.dto.payment.PaymentDTO;
import com.webmovieticket.dto.payment.PaymentResDTO;
import com.webmovieticket.models.Movies;
import com.webmovieticket.models.Tickets;
import com.webmovieticket.models.TransactionHis;
import com.webmovieticket.repository.MoviesRepository;
import com.webmovieticket.repository.TicketsRepository;
import com.webmovieticket.repository.TransactionHisRepository;
import com.webmovieticket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "test/payment")
public class PaymentController {

    @Autowired
    private TicketsRepository ticketsRepository;

    @Autowired
    private TransactionHisRepository transactionHisRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MoviesRepository moviesRepository;

    @PostMapping("/create-payment/{userId}")
    public ResponseEntity<?> createPayment(@PathVariable Long userId, @RequestBody PaymentDTO requestParams) throws IOException {

        try {
            Integer amount = 0;
            String ticketsToString = "?ticketsId=";
            for (Long ticketId : requestParams.getTicketsId()) {
                Tickets tickets = ticketsRepository.findById(ticketId).orElseThrow(() -> new RuntimeException());
                ticketsToString += ticketId.toString() + "-";
                amount += tickets.getPrice();
            }

            Map<String, String> vnp_Params = new HashMap<>();
            vnp_Params.put("vnp_Version", PaymentConfig.VERSIONVNPAY);
            vnp_Params.put("vnp_Command", PaymentConfig.COMMAND);
            vnp_Params.put("vnp_TmnCode", PaymentConfig.TMNCODE);
            vnp_Params.put("vnp_Amount", String.valueOf(amount * 100));
            vnp_Params.put("vnp_CurrCode", PaymentConfig.CURRCODE);
            vnp_Params.put("vnp_BankCode", requestParams.getBankCode());
//        vnp_Params.put("vnp_TxnRef", String.valueOf(orderDTO.getIdOrder())); // Mã tham chiếu của giao dịch tại hệ thống của merchant. Mã này là duy nhất dùng để phân biệt các đơn hàng gửi sang VNPAY. Không được trùng lặp trong ngày. Ví dụ: 23554
            vnp_Params.put("vnp_TxnRef", String.valueOf(requestParams.hashCode()));
            vnp_Params.put("vnp_OrderInfo", requestParams.getDescription());
            vnp_Params.put("vnp_OrderType", PaymentConfig.ORDERTYPE);
            vnp_Params.put("vnp_Locale", PaymentConfig.LOCALEDEFAULT);
            vnp_Params.put("vnp_ReturnUrl", PaymentConfig.RETURNURL + "/" + userId.toString() + ticketsToString);
            vnp_Params.put("vnp_IpAddr", PaymentConfig.IPDEFAULT);

            Date dt = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
            String dateString = formatter.format(dt);

            String vnp_CreateDate = dateString;
            vnp_Params.put("vnp_CreateDate", vnp_CreateDate);

            //Build data to hash and querystring
            List fieldNames = new ArrayList(vnp_Params.keySet());
            Collections.sort(fieldNames);
            StringBuilder hashData = new StringBuilder();
            StringBuilder query = new StringBuilder();
            Iterator itr = fieldNames.iterator();
            while (itr.hasNext()) {
                String fieldName = (String) itr.next();
                String fieldValue = (String) vnp_Params.get(fieldName);
                if ((fieldValue != null) && (fieldValue.length() > 0)) {
                    //Build hash data
                    hashData.append(fieldName);
                    hashData.append('=');
                    hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                    //Build query
                    query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
                    query.append('=');
                    query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                    if (itr.hasNext()) {
                        query.append('&');
                        hashData.append('&');
                    }
                }
            }

            String queryUrl = query.toString();
            String vnp_SecureHash = Config.hmacSHA512(PaymentConfig.CHECKSUM, hashData.toString());
            queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
            String paymentUrl = PaymentConfig.VNPAYURL + "?" + queryUrl;

            PaymentResDTO result = new PaymentResDTO();
            result.setStatus("00");
            result.setUrl(paymentUrl);
            result.setMessage("success");
            result.setUserId(userId);
            result.setTicketsId(requestParams.getTicketsId());

            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("can not found film id");
        }
    }

    @Transactional
    @GetMapping("/thong-tin-thanh-toan/{userId}")
    public ResponseEntity<?> transactionHandle(
            @PathVariable Long userId,
            @RequestParam(value = "ticketsId", required = false) String ticketsId,
            @RequestParam(value = "vnp_Amount", required = false) String amount,
            @RequestParam(value = "vnp_BankCode", required = false) String bankCode,
            @RequestParam(value = "vnp_BankTranNo", required = false) String bankTranNo,
            @RequestParam(value = "vnp_CardType", required = false) String cardType,
            @RequestParam(value = "vnp_PayDate", required = false) String payDate,
            @RequestParam(value = "vnp_OrderInfo", required = false) String orderInfo,
            @RequestParam(value = "vnp_TransactionNo", required = false) String transactionNo,
            @RequestParam(value = "vnp_ResponseCode", required = false) String responseCode,
            @RequestParam(value = "vnp_TransactionStatus", required = false) String transactionStatus,
            @RequestParam(value = "vnp_TxnRef", required = false) String txnRef,
            @RequestParam(value = "vnp_SecureHashType", required = false) String secureHashType,
            @RequestParam(value = "vnp_SecureHash", required = false) String secureHash
    ) {

        try {
            List<Long> listTicketId = new ArrayList<>();
            String ticketStr = "";
            for (int i = 0; i < ticketsId.length(); i++) {
                if (ticketsId.charAt(i) != '-') {
                    ticketStr += ticketsId.charAt(i);
                } else {
                    listTicketId.add(Long.parseLong(ticketStr));
                    ticketStr = "";
                }
            }

            Integer price = 0;
            Integer ticket = 0;

            for (Long ticketId : listTicketId) {
                Tickets tickets = ticketsRepository.findById(ticketId).orElseThrow(() -> new RuntimeException());
                tickets.setPaymentStatus(true);
                tickets.setUser(userRepository.findById(userId).orElseThrow(() -> new RuntimeException()));
                ticketsRepository.save(tickets);

                Movies movies = moviesRepository.findById(tickets.getMovies().getId()).orElseThrow(() -> new RuntimeException());
                movies.setSumPriceAudit(movies.getSumPriceAudit() + tickets.getPrice());
                movies.setSumTicketAudit(movies.getSumTicketAudit() + 1);
                moviesRepository.save(movies);
            }

            TransactionHis transactionHis = new TransactionHis();
            transactionHis.setAmount(Integer.valueOf(amount));
            transactionHis.setBankCode(bankCode);
            transactionHis.setBankTranNo(bankTranNo);
            transactionHis.setCardType(cardType);
            transactionHis.setPayDate(payDate);
            transactionHis.setOrderInfo(orderInfo);
            transactionHis.setTransactionNo(transactionNo);
            transactionHis.setResponseCode(responseCode);
            transactionHis.setTransactionStatus(transactionStatus);
            transactionHis.setTxnRef(txnRef);
            transactionHis.setSecureHash(secureHashType);
            transactionHis.setSecureHash(secureHash);
            transactionHis.setUserId(userId);
            transactionHis.setTickets(ticketsId);

            transactionHisRepository.save(transactionHis);

            return ResponseEntity.status(HttpStatus.OK).body("thanh toan thanh cong!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.OK).body("error");
        }
    }
}
