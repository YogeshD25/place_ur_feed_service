package com.imutable.coding.foundation.service.controller;



import com.imutable.coding.foundation.service.model.Place;
import com.imutable.coding.foundation.service.service.PlaceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/place")
@Slf4j
public class PlaceController {

    private PlaceService placeService;

    @Autowired
    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping
    public Flux<Place> getAllPlace() {
        log.info("Inside Place Controller in getAllPlace");
        return placeService.getAllPlace();
    }

    @GetMapping(path = "/byGeoFence")
    public Flux<Place> getPlaceUnderLocation(
            @RequestParam double placeLat,
            @RequestParam double placeLong,
            @RequestParam int placeProximity
    ) {
        log.info("Inside Place Controller in getPlaceUnderLocation");
        return placeService.getPlacesBasedOnLocation(placeLat, placeLong, placeProximity);
    }

    @PostMapping
    public Mono<Place> savePlace(@RequestBody Place place) {
        log.info("Inside Place Controller in savePlace");
        return placeService.savePlace(place);
    }

//    @GetMapping("/paging")
//    public ResponseEntity<Map<String, Object>> getAllPlacesByPaging(
//            @RequestParam(required = false) String title,
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "3") int size
//    ) {
//        try {
//            List<Place> tutorials = new ArrayList<>();
//            Pageable paging = PageRequest.of(page, size);
//
//            Page<Place> pageTuts;
//            if (title == null)
//                pageTuts = placeService.placeRepository.findAll(paging);
//            else
//                pageTuts = placeService.placeRepository.findByPlaceName(title, paging);
//
//            tutorials = pageTuts.getContent();
//
//            Map<String, Object> response = new HashMap<>();
//            response.put("places", tutorials);
//            response.put("currentPage", pageTuts.getNumber());
//            response.put("totalItems", pageTuts.getTotalElements());
//            response.put("totalPages", pageTuts.getTotalPages());
//
//            return new ResponseEntity<>(response, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

}
