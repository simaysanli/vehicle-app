package com.sharenow.interview.vehicleservice.vehicleservice.resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sharenow.interview.vehicleservice.vehicleservice.domain.model.PolygonDto;
import com.sharenow.interview.vehicleservice.vehicleservice.domain.model.VehicleDto;
import com.sharenow.interview.vehicleservice.vehicleservice.services.VehicleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/v1")
@Validated
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @Autowired
    ObjectMapper objectMapper;

    @CrossOrigin
    @Operation(summary = "Get all vehicles")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found all vehicles",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = VehicleDto.class))}),
            @ApiResponse(responseCode = "404", description = "Vehicles not found",
                    content = @Content)})
    @GetMapping(value = "vehicles")
    @Valid
    @Scheduled(fixedDelay = 60000)
    public List<VehicleDto> getAllVehiclesByLocation() throws JsonProcessingException {
        return vehicleService.getVehicleDataFromOpenAPI();
    }

    @CrossOrigin
    @Operation(summary = "Get all polygons")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found all polygons",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = VehicleDto.class))}),
            @ApiResponse(responseCode = "404", description = "Polygons not found",
                    content = @Content)})
    @GetMapping(value = "polygons", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PolygonDto> getData() throws IOException {
        return vehicleService.getAllPolygons();
    }

}
