package com.sharenow.interview.vehicleservice.vehicleservice.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VehicleDto {

    private Long id;

    private Long locationId;

    private String vin;

    private String plateNumber;

    private Position position;

    private double fuel;

    private String model;


}
