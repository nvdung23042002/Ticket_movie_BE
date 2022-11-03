package com.webmovieticket.controller;

import com.webmovieticket.dto.TheatreLoginDTO;
import com.webmovieticket.models.TheatreLogin;
import com.webmovieticket.service.TheatreLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class TheatreLoginController {

    @Autowired
    private TheatreLoginService theatreLoginService;

    @GetMapping("theatreLogin")
    public List<TheatreLoginDTO> findAll() {
        return theatreLoginService.findAll();
    }

    @GetMapping("theatreLogin/{id}")
    public TheatreLoginDTO findById(@PathVariable Long id) {
        return theatreLoginService.findById(id);
    }

    @PostMapping("theatreLogin")
    public void addTheatreLogin(@RequestBody TheatreLogin theatreLogin) {
        theatreLoginService.addTheatreLogin(theatreLogin);
    }

    @PutMapping("theatreLogin/{id}")
    public void updateTheatreLogin(@PathVariable Long id,@RequestBody TheatreLogin theatreLogin) {
        theatreLoginService.updateTheatreLogin(id, theatreLogin);
    }

    @DeleteMapping("theatreLogin/{id}")
    public void deleteTheatreLogin(@PathVariable Long id) {
        theatreLoginService.deleteTheatreLogin(id);
    }
}
