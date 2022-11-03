package com.webmovieticket.controller;

import com.webmovieticket.dto.LocationDTO;
import com.webmovieticket.models.Location;
import com.webmovieticket.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping("location")
    public List<LocationDTO> findAll() {
        return locationService.findAll();
    }

    @GetMapping("location/{id}")
    public LocationDTO findById(@PathVariable Long id) {
        return locationService.findById(id);
    }

    @PostMapping("location")
    public void addLocation(@RequestBody Location location) {
        locationService.addLocation(location);
    }

    @PutMapping("location/{id}")
    public void updateLocation(@PathVariable Long id,@RequestBody Location location) {
        locationService.updateLocation(id, location);
    }

    @DeleteMapping("location/{id}")
    public void deleteLocation(@PathVariable Long id) {
        locationService.deleteLocation(id);
    }
}
