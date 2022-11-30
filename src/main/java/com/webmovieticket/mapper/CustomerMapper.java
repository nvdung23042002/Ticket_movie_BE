package com.webmovieticket.mapper;

import com.webmovieticket.dto.CustomerDetailsDTO;
import com.webmovieticket.models.CustomerDetails;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerDetailsDTO toDto(CustomerDetails customerDetails) {
        CustomerDetailsDTO result = new CustomerDetailsDTO();

        if (customerDetails.getId() != null) {
            result.setId(customerDetails.getId());
        }

        if (customerDetails.getName() != null) {
            result.setName(customerDetails.getName());
        }

        if (customerDetails.getEmail() != null) {
            result.setEmail(customerDetails.getEmail());
        }

        if (customerDetails.getAddress() != null) {
            result.setAddress(customerDetails.getAddress());
        }

        if (customerDetails.getMobile() != null) {
            result.setMobile(customerDetails.getMobile());
        }

        return result;
    }

    public CustomerDetails toEntity(CustomerDetailsDTO customerDetailsDTO) {
        CustomerDetails result = new CustomerDetails();

        if (customerDetailsDTO.getName() != null) {
            result.setName(customerDetailsDTO.getName());
        }

        if (customerDetailsDTO.getEmail() != null) {
            result.setEmail(customerDetailsDTO.getEmail());
        }

        if (customerDetailsDTO.getAddress() != null) {
            result.setAddress(customerDetailsDTO.getAddress());
        }

        if (customerDetailsDTO.getMobile() != null) {
            result.setMobile(customerDetailsDTO.getMobile());
        }

        return result;
    }

    public CustomerDetails update(CustomerDetails oldCustomer, CustomerDetails newCustomer) {

        if (newCustomer.getName() != null) {
            oldCustomer.setName(newCustomer.getName());
        }

        if (newCustomer.getEmail() != null) {
            oldCustomer.setEmail(newCustomer.getEmail());
        }

        if (newCustomer.getAddress() != null) {
            oldCustomer.setAddress(newCustomer.getAddress());
        }

        if (newCustomer.getMobile() != null) {
            oldCustomer.setMobile(newCustomer.getMobile());
        }

        return oldCustomer;
    }
}
