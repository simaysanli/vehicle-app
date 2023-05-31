package com.sharenow.interview.vehicleservice.vehicleservice.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Geometry {
    private String type;
    private List<List<List<Double>>> coordinates;
}
