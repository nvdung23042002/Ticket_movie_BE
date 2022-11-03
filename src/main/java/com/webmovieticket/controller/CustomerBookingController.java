package com.webmovieticket.controller;

import com.webmovieticket.dto.CustomerBookingDTO;
import com.webmovieticket.models.CustomerBooking;
import com.webmovieticket.service.CustomerBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class CustomerBookingController {

    @Autowired
    private CustomerBookingService customerBookingService;

    @GetMapping("customerBooking")
    public List<CustomerBookingDTO> findAll() {
        return customerBookingService.findAll();
    }

    @GetMapping("customerBooking/{id}")
    public CustomerBookingDTO findById(@PathVariable Long id) {
        return customerBookingService.findById(id);
    }

    @PostMapping("customerBooking")
    public void addCustomerBooking(@RequestBody CustomerBooking customerBooking) {
        customerBookingService.addCustomerDetails(customerBooking);
    }

    @PutMapping("customerBooking/{id}")
    public void updateCustomerBooking(@PathVariable Long id, @RequestBody CustomerBooking customerBooking) {
        customerBookingService.updateCustomerDetails(id, customerBooking);
    }

    @DeleteMapping("customerBooking/{id}")
    public void deleteCustomerBooking(@PathVariable Long id) {
        customerBookingService.deleteCustomerDetails(id);
    }
}

