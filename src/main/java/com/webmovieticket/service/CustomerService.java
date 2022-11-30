package com.webmovieticket.service;

import com.webmovieticket.dto.CustomerDetailsDTO;
import com.webmovieticket.mapper.CustomerMapper;
import com.webmovieticket.models.CustomerDetails;
import com.webmovieticket.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    public List<CustomerDetailsDTO> findAll() {
        return customerRepository.findAll().stream().map(
                customerDetails -> customerMapper.toDto(customerDetails)).collect(Collectors.toList());
    }

    public CustomerDetailsDTO findById(Long id) {
        return customerMapper.toDto(customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException()));
    }

    @Transactional
    public CustomerDetailsDTO save(Long id, CustomerDetails customerDetails) {
        customerDetails.setId(id);
        CustomerDetails oldCustomer = customerRepository.findById(id).orElseGet(() -> null);

        if (oldCustomer != null) {
            return customerMapper.toDto(customerRepository.save(customerMapper.update(oldCustomer, customerDetails)));
        } else {
            return customerMapper.toDto(customerRepository.save(customerDetails));
        }
    }
}
