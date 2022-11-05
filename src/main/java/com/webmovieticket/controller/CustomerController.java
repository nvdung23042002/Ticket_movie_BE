package com.webmovieticket.controller;

import com.webmovieticket.dto.CustomerDetailsDTO;
import com.webmovieticket.models.CustomerDetails;
import com.webmovieticket.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/test/profile")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("")
    public List<CustomerDetailsDTO> findAll() {
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public CustomerDetailsDTO findById(@PathVariable Long id) {
        return customerService.findById(id);
    }


//    Cập nhật thông tin cá nhân
    @PostMapping("/{id}")
    public CustomerDetailsDTO update(@PathVariable Long id, @RequestBody CustomerDetails customerDetails) {
        return customerService.save(id, customerDetails);
    }
}
