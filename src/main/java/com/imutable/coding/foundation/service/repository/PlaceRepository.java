package com.imutable.coding.foundation.service.repository;


import com.imutable.coding.foundation.service.model.Place;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;

@Repository
public interface PlaceRepository extends ReactiveCrudRepository<Place,Long> {

    @Query("SELECT p FROM Place p WHERE p.geoHash IN(:one,:two,:three,:four,:five,:six,:seven,:eight,:nine)")
    Flux<Place> findRealtyClustersWithinGeoHash(
            @Param("one") String one,
            @Param("two") String two,
            @Param("three") String three,
            @Param("four") String four,
            @Param("five") String five,
            @Param("six") String six,
            @Param("seven") String seven,
            @Param("eight") String eight,
            @Param("nine") String nine);

}
