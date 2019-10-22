package com.tts.MapService;
import java.util.List;

import lombok.Data;

@Data
public class GeocodingReponse {
    private List<Geocoding> results;
}