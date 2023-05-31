package com.sharenow.interview.vehicleservice.vehicleservice.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ActiveTimedOptions {
    private int min;
    private int max;
    private int idleTime;
    private int revenue;
    private int walkingRange1;
    private int walkingRange2;

}
