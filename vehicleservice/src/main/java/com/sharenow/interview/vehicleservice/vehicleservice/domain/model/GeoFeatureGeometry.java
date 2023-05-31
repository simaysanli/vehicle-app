package com.sharenow.interview.vehicleservice.vehicleservice.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class GeoFeatureGeometry {
    private String type;
    private List<Double> coordinates;
}
