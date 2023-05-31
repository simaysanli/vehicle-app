package com.sharenow.interview.vehicleservice.vehicleservice.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Options {
    private boolean active;
    @JsonProperty("is_excluded")
    private boolean isExcluded;
    private double area;

}
