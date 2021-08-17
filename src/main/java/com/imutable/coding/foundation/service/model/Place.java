package com.imutable.coding.foundation.service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Table( "point_of_interest")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Place {

    @Id
    @JsonIgnore
    private long placeId;
    @Column
    private String placeName;
    @Column
    private long categoryId;
    @Column
    private String categoryName;
    @Column
    private double placeLat;
    @Column
    private double placeLong;
    @Column
    private String placeDescription;
    @Column
    private String placeImageUrl;
    @Column
    private String geoHash;
    @Column
    private float placeRating;
    @Column
    private String placeCity;

}
