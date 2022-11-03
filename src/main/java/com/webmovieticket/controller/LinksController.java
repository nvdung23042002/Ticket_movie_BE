package com.webmovieticket.controller;

import com.webmovieticket.dto.LinksDTO;
import com.webmovieticket.models.Links;
import com.webmovieticket.service.LinksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class LinksController {

    @Autowired
    private LinksService linksService;

    @GetMapping("links")
    public List<LinksDTO> findAll(){
        return linksService.findAll();
    }

    @GetMapping("links/{id}")
    public LinksDTO findById(@PathVariable Long id) {
        return linksService.findById(id);
    }

    @PostMapping("links")
    public void addLinks(@RequestBody Links links) {
        linksService.addLinks(links);
    }

    @PutMapping("links/{id}")
    public void updateLinks(@PathVariable Long id,@RequestBody Links links) {
        linksService.updateLinks(id, links);
    }

    @DeleteMapping("links/{id}")
    public void DeleteLinks(@PathVariable Long id) {
        linksService.deleteLinks(id);
    }
}
