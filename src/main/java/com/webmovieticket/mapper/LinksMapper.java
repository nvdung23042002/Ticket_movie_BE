package com.webmovieticket.mapper;

import com.webmovieticket.dto.LinksDTO;
import com.webmovieticket.models.Links;
import org.springframework.stereotype.Component;

@Component
public class LinksMapper {

    public LinksDTO returnDTO(Links links) {

        LinksDTO linksDTO = new LinksDTO();

        linksDTO.setId(links.getId());
        linksDTO.setLink(links.getLink());
        return linksDTO;
    }

    public Links returnEntity(LinksDTO linksDTO) {
        Links links = new Links();

        links.setId(linksDTO.getId());
        links.setLink(linksDTO.getLink());
        return links;
    }
}
