package com.sharenow.interview.vehicleservice.vehicleservice.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class PolygonDto {

    @JsonProperty("_id")
    private String id;
    private Date updatedAt;
    private Date createdAt;
    @JsonProperty("__v")
    private int v;
    private String name;
    private String cityId;
    private String legacyId;
    private String type;
    private List<GeoFeature> geoFeatures;
    private Options options;
    private List<TimedOptions> timedOptions;
    private Geometry geometry;
    private int version;
    private Computed computed;


}
