package com.imutable.coding.foundation.service.service;



import ch.hsr.geohash.GeoHash;
import com.imutable.coding.foundation.service.model.Place;
import com.imutable.coding.foundation.service.repository.PlaceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@Slf4j
public class PlaceService {


    public PlaceRepository placeRepository;

    @Autowired
    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public Mono<Place> savePlace(Place place) {
        log.info("Inside Place Service for Saving place");
        GeoHash hash = GeoHash.withBitPrecision(place.getPlaceLat(), place.getPlaceLong(), 25);
        place.setGeoHash(hash.toBase32());
        return placeRepository.save(place);
    }

    public Flux<Place> getAllPlace() {
        log.info("Inside Place Service for getting all places");
        return placeRepository.findAll();
    }


    public Flux<Place> getPlacesBasedOnLocation(double placeLat, double placeLong, int placeProximity) {

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

        Flux<Place> list = placeRepository.findRealtyClustersWithinGeoHash(
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

        return list;
    }
}
