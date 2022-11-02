package com.webmovieticket.mapper;

import com.webmovieticket.dto.CustomerDetailsDTO;
import com.webmovieticket.models.CustomerDetails;
import org.springframework.stereotype.Component;


@Component
public class CustomerDetailsMapper {

    public CustomerDetailsDTO returnDto(CustomerDetails customerDetails) {
        CustomerDetailsDTO result = new CustomerDetailsDTO();

        result.setCust_id(customerDetails.getCust_id());
        result.setName(customerDetails.getName());
        result.setEmail(customerDetails.getEmail());
        result.setMobile(customerDetails.getMobile());
        result.setType(customerDetails.getType());
        result.setPayment_status(customerDetails.getPayment_status());
        result.setAmount(customerDetails.getAmount());
        result.setPay_amount(customerDetails.getPay_amount());
        result.setPayment_date(customerDetails.getPayment_date());
        result.setTransid(customerDetails.getTransid());
        return result;
    }

    public CustomerDetails returnEntity(CustomerDetailsDTO customerDetailsDTO) {
        CustomerDetails result = new CustomerDetails();

        result.setCust_id(customerDetailsDTO.getCust_id());
        result.setName(customerDetailsDTO.getName());
        result.setEmail(customerDetailsDTO.getEmail());
        result.setMobile(customerDetailsDTO.getMobile());
        result.setType(customerDetailsDTO.getType());
        result.setPayment_status(customerDetailsDTO.getPayment_status());
        result.setAmount(customerDetailsDTO.getAmount());
        result.setPay_amount(customerDetailsDTO.getPay_amount());
        result.setPayment_date(customerDetailsDTO.getPayment_date());
        result.setTransid(customerDetailsDTO.getTransid());

        return result;
    }
}
