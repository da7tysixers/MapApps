package com.tts.MapService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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

/*
 * few simple classes so that we can convert 
 * that JSON string into a Java object, 
 * a process called deserialization.
 */

@Data
public class GeocodingReponse {
    private List<Geocoding> results;
}

@Data
public class Geocoding {
    private Geometry geometry;
}

@Data
public class Geometry {
    private Location location;
}

@Data
public class Location {
    private String city;
    private String state;
    private String lat;
    private String lng;
}