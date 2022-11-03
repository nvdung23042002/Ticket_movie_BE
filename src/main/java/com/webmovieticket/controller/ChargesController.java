package com.webmovieticket.controller;

import com.webmovieticket.dto.ChargesDTO;
import com.webmovieticket.models.Charges;
import com.webmovieticket.service.ChargesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ChargesController {

    @Autowired
    private ChargesService chargesService;

    @GetMapping("charges")
    public List<ChargesDTO> findAll() {
        return chargesService.findAll();
    }

    @GetMapping("charges/{id}")
    public ChargesDTO findById(@PathVariable Long id) {
        return chargesService.findById(id);
    }

    @PostMapping("charges")
    public void addCharges(@RequestBody Charges charges) {
        chargesService.addCharges(charges);
    }

    @PutMapping("charges/{id}")
    public void updateCharges(@PathVariable Long id,@RequestBody Charges charges) {
        chargesService.updateCharges(id, charges);
    }

    @DeleteMapping("charges/{id}")
    public void deleteCharges(@PathVariable Long id) {
        chargesService.deleteCharges(id);
    }
}
