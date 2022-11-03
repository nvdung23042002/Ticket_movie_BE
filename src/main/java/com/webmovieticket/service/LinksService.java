package com.webmovieticket.service;

import com.webmovieticket.dto.LinksDTO;
import com.webmovieticket.mapper.LinksMapper;
import com.webmovieticket.models.Links;
import com.webmovieticket.repository.LinksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LinksService {

    @Autowired
    private LinksMapper linksMapper;

    @Autowired
    private LinksRepository linksRepository;

    public List<LinksDTO> findAll() {
        return linksRepository.findAll().stream().map(
                links -> linksMapper.returnDTO(links)).collect(Collectors.toList());
    }

    public LinksDTO findById(Long id) {
        return linksMapper.returnDTO(linksRepository.findById(id).orElseThrow(() -> new RuntimeException()));
    }

    public void addLinks(Links links) {
        linksRepository.save(links);
    }

    public void updateLinks(Long id, Links links) {

        Links oldLinks = linksRepository.findById(id).orElseGet(() -> null);

        if (oldLinks != null) {
            oldLinks.setLink(links.getLink());

            linksRepository.save(oldLinks);
        }
    }

    public void deleteLinks(Long id) {
        linksRepository.deleteById(id);
    }

}
