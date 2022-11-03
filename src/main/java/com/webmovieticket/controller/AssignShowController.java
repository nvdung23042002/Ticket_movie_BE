package com.webmovieticket.controller;

import com.webmovieticket.dto.AssignShowDTO;
import com.webmovieticket.models.AssignShow;
import com.webmovieticket.service.AssignShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class AssignShowController {

    @Autowired
    private AssignShowService assignShowService;

    @GetMapping("assignShow")
    public List<AssignShowDTO> findAll() {
        return assignShowService.findAll();
    }

    @GetMapping("assignShow/{id}")
    public AssignShowDTO findById(@PathVariable Long id) {
        return assignShowService.findById(id);
    }

    @PostMapping("assignShow")
    public void addAssignShow(@RequestBody AssignShow assignShow) {
        assignShowService.addAssignShow(assignShow);
    }

    @PutMapping("assignShow/{id}")
    public void updateAssignShow(@PathVariable Long id,@RequestBody AssignShow assignShow) {
        assignShowService.updateAssignShow(id, assignShow);
    }

    @DeleteMapping("assignShow/{id}")
    public void deleteAssignShow(@PathVariable Long id) {
        assignShowService.deleteAssignShow(id);
    }
}
