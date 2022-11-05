package com.webmovieticket.mapper;

import com.webmovieticket.dto.CustomerDetailsDTO;
import com.webmovieticket.models.CustomerDetails;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerDetailsDTO toDto(CustomerDetails customerDetails) {
        CustomerDetailsDTO result = new CustomerDetailsDTO();

        result.setId(customerDetails.getId());
        result.setCreatedAt(customerDetails.getCreatedAt());
        result.setDeletedAt(customerDetails.getDeletedAt());
        result.setIsPresent(customerDetails.getIsPresent());
        result.setName(customerDetails.getName());
        result.setEmail(customerDetails.getEmail());
        result.setAddress(customerDetails.getAddress());
        result.setMobile(customerDetails.getMobile());

        return result;
    }

    public CustomerDetails toEntity(CustomerDetailsDTO customerDetailsDTO) {
        CustomerDetails result = new CustomerDetails();

        result.setCreatedAt(customerDetailsDTO.getCreatedAt());
        result.setDeletedAt(customerDetailsDTO.getDeletedAt());
        result.setIsPresent(customerDetailsDTO.getIsPresent());
        result.setName(customerDetailsDTO.getName());
        result.setEmail(customerDetailsDTO.getEmail());
        result.setAddress(customerDetailsDTO.getAddress());
        result.setMobile(customerDetailsDTO.getMobile());

        return result;
    }

    public CustomerDetailsDTO update(CustomerDetails oldCustomer, CustomerDetails newCustomer) {
        oldCustomer.setCreatedAt(newCustomer.getCreatedAt());
        oldCustomer.setDeletedAt(newCustomer.getDeletedAt());
        oldCustomer.setIsPresent(newCustomer.getIsPresent());
        oldCustomer.setName(newCustomer.getName());
        oldCustomer.setEmail(newCustomer.getEmail());
        oldCustomer.setAddress(newCustomer.getAddress());
        oldCustomer.setMobile(newCustomer.getMobile());

        return CustomerMapper.this.toDto(oldCustomer);
    }
}
