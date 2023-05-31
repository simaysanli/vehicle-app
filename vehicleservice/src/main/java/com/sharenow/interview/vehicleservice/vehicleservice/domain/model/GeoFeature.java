package com.sharenow.interview.vehicleservice.vehicleservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeoFeature {
    private String name;
    private GeoFeatureGeometry geometry;

}
