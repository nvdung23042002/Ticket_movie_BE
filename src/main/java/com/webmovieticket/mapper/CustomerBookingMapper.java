package com.webmovieticket.mapper;

import com.webmovieticket.dto.CustomerBookingDTO;
import com.webmovieticket.models.CustomerBooking;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CustomerBookingMapper {
    public CustomerBookingDTO returnDTO(CustomerBooking customerBooking) {
        CustomerBookingDTO customerBookingDTO = new CustomerBookingDTO();

        customerBookingDTO.setId(customerBooking.getId());
        customerBookingDTO.setFk_show_id(customerBooking.getFk_show_id());
        customerBookingDTO.setSeat_id(customerBooking.getSeat_id());
        customerBookingDTO.setSeat_name(customerBooking.getSeat_name());
        customerBookingDTO.setChanges(customerBooking.getChanges());
        customerBookingDTO.setShow_date(customerBooking.getShow_date());
        customerBookingDTO.setShow_time(customerBooking.getShow_time());
        customerBookingDTO.setBooking_dt(customerBooking.getBooking_dt());
        customerBookingDTO.setFk_cust_id(customerBooking.getFk_cust_id());
        customerBookingDTO.setFk_movie_id(customerBooking.getFk_movie_id());
        customerBookingDTO.setConvenience(customerBooking.getConvenience());
        customerBookingDTO.setServiceTax(customerBooking.getServiceTax());
        customerBookingDTO.setConcession(customerBooking.getConcession());
        return customerBookingDTO;
    }

    public CustomerBooking returnEntity(CustomerBookingDTO customerBookingDTO) {
        CustomerBooking customerBooking = new CustomerBooking();

        customerBooking.setId(customerBookingDTO.getId());
        customerBooking.setFk_show_id(customerBookingDTO.getFk_show_id());
        customerBooking.setSeat_id(customerBookingDTO.getSeat_id());
        customerBooking.setSeat_name(customerBookingDTO.getSeat_name());
        customerBooking.setChanges(customerBookingDTO.getChanges());
        customerBooking.setShow_date(customerBookingDTO.getShow_date());
        customerBooking.setShow_time(customerBookingDTO.getShow_time());
        customerBooking.setBooking_dt(customerBookingDTO.getBooking_dt());
        customerBooking.setFk_cust_id(customerBookingDTO.getFk_cust_id());
        customerBooking.setFk_movie_id(customerBookingDTO.getFk_movie_id());
        customerBooking.setConvenience(customerBookingDTO.getConvenience());
        customerBooking.setServiceTax(customerBookingDTO.getServiceTax());
        customerBooking.setConcession(customerBookingDTO.getConcession());
        return customerBooking;
    }
}
