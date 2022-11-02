package com.webmovieticket.service;

import com.webmovieticket.dto.CustomerBookingDTO;
import com.webmovieticket.dto.CustomerDetailsDTO;
import com.webmovieticket.mapper.CustomerBookingMapper;
import com.webmovieticket.mapper.CustomerDetailsMapper;
import com.webmovieticket.models.CustomerBooking;
import com.webmovieticket.models.CustomerDetails;
import com.webmovieticket.repository.CustomerBookingRepository;
import com.webmovieticket.repository.CustomerDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class CustomerBookingService {
    @Autowired
    private CustomerBookingMapper customerBookingMapper;

    @Autowired
    private CustomerBookingRepository customerBookingRepository;

    public List<CustomerBookingDTO> findAll() {
        return customerBookingRepository.findAll().stream().map(
                customerBooking -> customerBookingMapper.returnDTO(customerBooking)).collect(Collectors.toList());
    }

    public CustomerBookingDTO findById(Long id) {
        return customerBookingMapper.returnDTO(customerBookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException()));
    }

    public void addCustomerDetails(CustomerBooking customerBooking) {
        customerBookingRepository.save(customerBooking);
    }

    public CustomerBookingDTO updateCustomerDetails(Long id, CustomerBooking customerBooking) {
        CustomerBooking oldCustomerBooking = customerBookingRepository.findById(id).orElseGet(() -> null);

        if (oldCustomerBooking != null) {
            oldCustomerBooking.setFk_show_id(customerBooking.getFk_show_id());
            oldCustomerBooking.setSeat_id(customerBooking.getSeat_id());
            oldCustomerBooking.setSeat_name(customerBooking.getSeat_name());
            oldCustomerBooking.setChanges(customerBooking.getChanges());
            oldCustomerBooking.setShow_date(customerBooking.getShow_date());
            oldCustomerBooking.setShow_time(customerBooking.getShow_time());
            oldCustomerBooking.setBooking_dt(customerBooking.getBooking_dt());
            oldCustomerBooking.setFk_cust_id(customerBooking.getFk_cust_id());
            oldCustomerBooking.setFk_movie_id(customerBooking.getFk_movie_id());
            oldCustomerBooking.setConvenience(customerBooking.getConvenience());
            oldCustomerBooking.setServiceTax(customerBooking.getServiceTax());
            oldCustomerBooking.setConcession(customerBooking.getConcession());
        }
        customerBookingRepository.save(oldCustomerBooking);
        return customerBookingMapper.returnDTO(oldCustomerBooking);
    }

    public void deleteCustomerDetails(Long cust_id) {
        customerBookingRepository.deleteById(cust_id);
    }
}



