package com.webmovieticket.service;

import com.webmovieticket.dto.ChargesDTO;
import com.webmovieticket.mapper.ChargesMapper;
import com.webmovieticket.models.Charges;
import com.webmovieticket.repository.ChargesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChargesService {

    @Autowired
    private ChargesMapper chargesMapper;

    @Autowired
    private ChargesRepository chargesRepository;

    public List<ChargesDTO> findAll() {
        return chargesRepository.findAll().stream().map(
                charges -> chargesMapper.returnDTO(charges)).collect(Collectors.toList());
    }

    public ChargesDTO findById(Long charge_id) {
        return chargesMapper.returnDTO(chargesRepository.findById(charge_id)
                .orElseThrow(() -> new RuntimeException()));
    }

    public void addCharges(Charges charges) {
        chargesRepository.save(charges);
    }

    public void updateCharges(Long id, Charges charges) {

        Charges oldCharges = chargesRepository.findById(id).orElseGet(() -> null);

        if (oldCharges != null) {
            oldCharges.setTd_id(charges.getTd_id());
            oldCharges.setSeat_name(charges.getSeat_name());
            oldCharges.setCharges(charges.getCharges());

            chargesRepository.save(oldCharges);
        }

    }

    public void deleteCharges(Long id) {
        chargesRepository.deleteById(id);
    }
}
