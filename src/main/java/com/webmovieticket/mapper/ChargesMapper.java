package com.webmovieticket.mapper;

import com.webmovieticket.dto.ChargesDTO;
import com.webmovieticket.models.Charges;
import org.springframework.stereotype.Component;

@Component
public class ChargesMapper {

    public ChargesDTO returnDTO (Charges charges) {
        ChargesDTO chargesDTO = new ChargesDTO();

        chargesDTO.setCharge_id(charges.getCharge_id());
        chargesDTO.setTd_id(charges.getTd_id());
        chargesDTO.setSeat_name(charges.getSeat_name());
        chargesDTO.setCharges(charges.getCharges());

        return chargesDTO;
    }

    public Charges returnEntity (ChargesDTO chargesDTO) {
        Charges charges = new Charges();

        charges.setCharge_id(chargesDTO.getCharge_id());
        charges.setTd_id(chargesDTO.getTd_id());
        charges.setSeat_name(chargesDTO.getSeat_name());
        charges.setCharges(chargesDTO.getCharges());

        return charges;
    }

}
