package com.sharenow.interview.vehicleservice.vehicleservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Position {

    private Long latitude;

    private Long longitude;
}
