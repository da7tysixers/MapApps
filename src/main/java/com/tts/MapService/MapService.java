package com.tts.MapService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.Data;

@Service
public class MapService {
    @Value("${api_key}")
    private String apiKey;

    public void addCoordinates(Location location) {
        String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" + 
        location.getCity() + "," + location.getState() + "&key=" + apiKey;
        
        // RestfulTemplate class the API call and deserialize it into an object of type GeocodingReponse.
        RestTemplate restTemplate = new RestTemplate();
        GeocodingResponse response = restTemplate.getForObject(url, GeocodingResponse.class);
        Location coordinates = response.getResults().get(0).getGeometry().getLocation();
        
        // set cordinates for our passed location object.
        location.setLat(coordinates.getLat());
        location.setLng(coordinates.getLng());
        
    }
    
    

}