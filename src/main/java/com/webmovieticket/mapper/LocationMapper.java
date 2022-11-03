package com.webmovieticket.mapper;

import com.webmovieticket.dto.LocationDTO;
import com.webmovieticket.models.Location;
import org.springframework.stereotype.Component;

@Component
public class LocationMapper {

    public LocationDTO returnDTO(Location location) {
        LocationDTO locationDTO = new LocationDTO();

        locationDTO.setId(location.getId());
        locationDTO.setLocation(location.getLocation());

        return locationDTO;
    }

    public Location returnEntity(LocationDTO locationDTO) {
        Location location = new Location();

        location.setId(locationDTO.getId());
        location.setLocation(locationDTO.getLocation());

        return location;
    }
}
