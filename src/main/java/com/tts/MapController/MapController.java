package com.tts.MapController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tts.MapService.Location;



@Controller
	public class MapController {
	   @GetMapping("/home")
	   public String getDefaultMap(Model model) {
		   Location location = new Location();
		   location.setCity("Dallas");
		   location.setState("Texas");
		   mapService.addCoordinates(location);
		   System.out.println(location);
		   model.addAttribute(new Location());
	       return "index.html";
	   }
	   
	   // post made by html form.
@PostMapping("/home")
	public String getMapForLocation(Location location, Model model) {
	       mapService.addCoordinates(location);
	       model.addAttribute(location);
	       return "index.html";
	   }
	}

