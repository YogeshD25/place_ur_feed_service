package com.imutable.coding.foundation.service.service;



import ch.hsr.geohash.GeoHash;
import com.imutable.coding.foundation.service.model.Place;
import com.imutable.coding.foundation.service.repository.PlaceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PlaceService {


    public PlaceRepository placeRepository;

    @Autowired
    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public void savePlace(Place place) {
        log.info("Inside Place Service for Saving place");
        GeoHash hash = GeoHash.withBitPrecision(place.getPlaceLat(), place.getPlaceLong(), 25);
        place.setGeoHash(hash.toBase32());
        placeRepository.save(place);
    }

    public List<Place> getAllPlace() {
        log.info("Inside Place Service for getting all places");
        return placeRepository.findAll();
    }

    //Naive Approach for Proximity Scanning
//    public List<Place> getPlacesBasedOnLocationNaive(double placeLat, double placeLong, int radius) {
//
//        GeoHash hash = GeoHash.withBitPrecision(placeLat, placeLong, 30);
//        BoundingBox box = hash.getBoundingBox();
//
//        List<Place> list = placeRepository.findRealtyClustersWithinBounds(box.getSouthLatitude(), box.getWestLongitude(),
//                box.getNorthLatitude(), box.getEastLongitude());
//
//        GeoHashCircleQuery query = new GeoHashCircleQuery(new WGS84Point(placeLat, placeLong), radius);
//
//        List<Place> placeInRadius = new ArrayList<>();
//        for (Place place : list) {
//            if (query.contains(new WGS84Point(
//                    place.getPlaceLat(),
//                    place.getPlaceLong()))) {
//                placeInRadius.add(place);
//            }
//        }
//
//        return placeInRadius;
//    }

    public List<Place> getPlacesBasedOnLocation(double placeLat, double placeLong, int placeProximity) {

        GeoHash hash = GeoHash.withBitPrecision(placeLat, placeLong, 25);
        GeoHash[] geoHashes = hash.getAdjacent();

        log.info("Values " + geoHashes[0].toBase32() + "\n" +
                geoHashes[1].toBase32() + "\n" +
                geoHashes[2].toBase32() + "\n" +
                geoHashes[3].toBase32() + "\n" +
                geoHashes[4].toBase32() + "\n" +
                geoHashes[5].toBase32() + "\n" +
                geoHashes[6].toBase32() + "\n" +
                geoHashes[7].toBase32() + "\n" +
                hash.toBase32());

        List<Place> list = placeRepository.findRealtyClustersWithinGeoHash(
                geoHashes[0].toBase32(),
                geoHashes[1].toBase32(),
                geoHashes[2].toBase32(),
                geoHashes[3].toBase32(),
                geoHashes[4].toBase32(),
                geoHashes[5].toBase32(),
                geoHashes[6].toBase32(),
                geoHashes[7].toBase32(),
                hash.toBase32()
        );


        //TODO Cross Verification for GeoCircleFenceQuery
//        GeoHashCircleQuery query = new GeoHashCircleQuery(new WGS84Point(placeLat, placeLong), radius);
//
//        List<Place> placeInRadius = new ArrayList<>();
//        for (Place place : list) {
//            if (query.contains(new WGS84Point(
//                    place.getPlaceLat(),
//                    place.getPlaceLong()))) {
//                placeInRadius.add(place);
//            }
//        }

        return list;
    }
}
