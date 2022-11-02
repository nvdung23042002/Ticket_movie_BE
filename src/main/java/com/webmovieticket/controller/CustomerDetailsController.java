package com.webmovieticket.controller;

import com.webmovieticket.dto.CustomerDetailsDTO;
import com.webmovieticket.models.CustomerDetails;
import com.webmovieticket.repository.CustomerDetailsRepository;
import com.webmovieticket.service.CustomerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class CustomerDetailsController {

    @Autowired
    CustomerDetailsService customerDetailsService;

    @GetMapping("customerDetail")
    public List<CustomerDetailsDTO> findAll() {
        return customerDetailsService.findAll();
    }

    @GetMapping("customerDetail/{cust_id}")
    public CustomerDetailsDTO findById(@PathVariable Long cust_id) {
        return customerDetailsService.findById(cust_id);
    }

    @PostMapping("customerDetail")
    public void addCustomerDetails(@RequestBody CustomerDetails customerDetails) {
        customerDetailsService.addCustomerDetails(customerDetails);
    }

    @PutMapping("customerDetail/{cust_id}")
    public CustomerDetailsDTO updateCustomerDetails(@PathVariable Long cust_id, @RequestBody CustomerDetails customerDetails) {
        return customerDetailsService.updateCustomerDetails(cust_id, customerDetails);

    }

    @DeleteMapping("customerDetail/{cust_id}")
    public void deleteCustomerDetails(@PathVariable Long cust_id) {
        customerDetailsService.deleteCustomerDetails(cust_id);
    }


}
