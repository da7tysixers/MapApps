var map;
// customizing my image for the map pointer that shows your location.
var image = {url: '/custom_marker.png', 
	    scaledSize: new google.maps.Size(50, 50)};
// adding image to the marker definition
var marker = new google.maps.Marker({
    position: coords,
    map: map,
    icon: image
    // makes the marker bounce on the page once it loads.
    animation: google.maps.Animation.BOUNCE
});

// created the initMap function that gets the google map
function initMap() {
    map = new google.maps.Map(document.getElementById('map'), {
        center: {lat: 39.9612, lng: -82.9988},
        zoom: 10,
        scrollwheel: false
        var marker = new google.maps.Marker({
            position: coords,
            map: map
        });
        
      // information that shows on the marker/pointer when the user clicks on it.
        var contentString = '<h2>' + city + ', ' + state + '</h2>';

        var infowindow = new google.maps.InfoWindow({
          content: contentString
        });

        google.maps.event.addListener(marker, 'click', function() {
           infowindow.open(map,marker);
        });
    });
}