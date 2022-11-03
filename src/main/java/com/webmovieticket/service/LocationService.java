package com.webmovieticket.service;

import com.webmovieticket.dto.LocationDTO;
import com.webmovieticket.mapper.LocationMapper;
import com.webmovieticket.models.Location;
import com.webmovieticket.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationService {

    @Autowired
    private LocationMapper locationMapper;

    @Autowired
    private LocationRepository locationRepository;

    public List<LocationDTO> findAll() {
        return locationRepository.findAll().stream().map(
                location -> locationMapper.returnDTO(location)).collect(Collectors.toList());
    }

    public LocationDTO findById(Long id) {
        return locationMapper.returnDTO(locationRepository.findById(id).orElseThrow(() -> new RuntimeException()));
    }

    public void addLocation(Location location) {
        locationRepository.save(location);
    }

    public void updateLocation(Long id, Location location) {

        Location oldLocation = locationRepository.findById(id).orElseGet(() -> null);

        if (oldLocation != null) {
            oldLocation.setLocation(location.getLocation());

            locationRepository.save(oldLocation);
        }
    }

    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }
}
