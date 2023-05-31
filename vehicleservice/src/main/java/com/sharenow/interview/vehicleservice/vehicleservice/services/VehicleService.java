package com.sharenow.interview.vehicleservice.vehicleservice.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.sharenow.interview.vehicleservice.vehicleservice.domain.model.PolygonDto;
import com.sharenow.interview.vehicleservice.vehicleservice.domain.model.Position;
import com.sharenow.interview.vehicleservice.vehicleservice.domain.model.VehicleDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class VehicleService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    //TODO: convert stream
    public List<VehicleDto> getVehicleDataFromOpenAPI() throws JsonProcessingException {
        String url = "https://web-chapter-coding-challenge-api-eu-central-1.dev.architecture.ridedev.io/api/architecture/web-chapter-coding-challenge-api/vehicles/Stuttgart";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        String responseBody = response.getBody();
        JsonNode jsonNode = objectMapper.readTree(responseBody);
        List<VehicleDto> vehicleList = new ArrayList<>();
        JsonNode data = jsonNode.get("data");
        if (data.isArray()) {
            data.forEach(vehicle -> {
                VehicleDto vehicleDto = new VehicleDto();
                vehicleDto.setId(vehicle.get("id").asLong());
                vehicleDto.setLocationId(vehicle.get("locationId").asLong());
                vehicleDto.setVin(vehicle.get("vin").asText());
                vehicleDto.setPlateNumber(vehicle.get("numberPlate").asText());
                JsonNode position = vehicle.get("position");
                Long latitude = position.get("latitude").asLong();
                Long longitude = position.get("longitude").asLong();
                vehicleDto.setPosition(new Position(latitude, longitude));
                vehicleDto.setFuel(vehicle.get("fuel").asDouble());
                vehicleDto.setModel(vehicle.get("model").asText());
                vehicleList.add(vehicleDto);
            });

        }
        return vehicleList;
    }

    public List<PolygonDto> getAllPolygons() throws JsonProcessingException {
        String json = "";
        try(InputStream stream = getClass().getResourceAsStream("/polygons.json")) {
            json = StreamUtils.copyToString(stream, Charset.forName("UTF-8"));
        } catch (IOException ioe) {
            System.out.println("Couldn't fetch JSON! Error: " +
                    ioe.getMessage());
        }

        List<PolygonDto> myDtoList = objectMapper.readValue(json, TypeFactory.defaultInstance().constructCollectionType(List.class, PolygonDto.class));
        return myDtoList;
    }


}
