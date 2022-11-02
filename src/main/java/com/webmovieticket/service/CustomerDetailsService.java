package com.webmovieticket.service;

import com.webmovieticket.dto.CustomerDetailsDTO;
import com.webmovieticket.mapper.CustomerDetailsMapper;
import com.webmovieticket.models.CustomerDetails;
import com.webmovieticket.repository.CustomerDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerDetailsService {

    @Autowired
    private CustomerDetailsMapper customerDetailsMapper;

    @Autowired
    private CustomerDetailsRepository customerDetailsRepository;

    public List<CustomerDetailsDTO> findAll() {
        return customerDetailsRepository.findAll().stream().map(
                customerDetails -> customerDetailsMapper.returnDto(customerDetails)).collect(Collectors.toList());
    }

    public CustomerDetailsDTO findById(Long cust_id) {
        return customerDetailsMapper.returnDto(customerDetailsRepository.findById(cust_id)
                .orElseThrow(() -> new RuntimeException()));
    }

    public void addCustomerDetails(CustomerDetails customerDetails) {
        customerDetailsRepository.save(customerDetails);
    }

    public CustomerDetailsDTO updateCustomerDetails(Long id, CustomerDetails customerDetails) {
        CustomerDetails oldCustomerDetails = customerDetailsRepository.findById(id).orElseGet(() -> null);

        if (oldCustomerDetails != null) {
            oldCustomerDetails.setName(customerDetails.getName());
            oldCustomerDetails.setEmail(customerDetails.getEmail());
            oldCustomerDetails.setMobile(customerDetails.getMobile());
            oldCustomerDetails.setType(customerDetails.getType());
            oldCustomerDetails.setPayment_status(customerDetails.getPayment_status());
            oldCustomerDetails.setAmount(customerDetails.getAmount());
            oldCustomerDetails.setPay_amount(customerDetails.getPay_amount());
            oldCustomerDetails.setPayment_date(customerDetails.getPayment_date());
            oldCustomerDetails.setTransid(customerDetails.getTransid());
        }
        customerDetailsRepository.save(oldCustomerDetails);
        return customerDetailsMapper.returnDto(oldCustomerDetails);
    }

    public void deleteCustomerDetails(Long cust_id) {
        customerDetailsRepository.deleteById(cust_id);
    }
}