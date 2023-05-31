package com.sharenow.interview.vehicleservice.vehicleservice.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class TimedOptions {
    private String key;
    private List<List<Integer>> changesOverTime;
}
