package com.tts.MapController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.tts.MapService.Location;

@Controller
	public class MapController {
	   @GetMapping("/home")
	   public String getDefaultMap() {
		   Location location = new Location();
		   location.setCity("Dallas");
		   location.setState("Texas");
		   mapService.addCoordinates(location);
		   System.out.println(location);
	       return "index.html";
	   }
	}

