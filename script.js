mapboxgl.accessToken = 
'pk.eyJ1IjoiYnRlbmV2IiwiYSI6ImNsNWptam84bjAxa2gzb254eTJkbTF6d3YifQ.GFjVlFEQh63xJ0PCFleDTw';

navigator.geolocation.getCurrentPosition(successLocation, 
  errorLocation, {
    enableHighAccuracy: true
  })

  function successLocation(position) {
    setupMap([position.coords.longitude, position.coords.latitude])
  }

  function errorLocation() {
    setupMap([42.1354, 24.7453])
  }

function setupMap(center) {
  const map = new mapboxgl.Map({
    container: 'map',
    style: 'mapbox://styles/mapbox/streets-v11',
    center: center,
    zoom: 14
  })

  const nav = new mapboxgl.NavigationControl();
  map.addControl(nav)

  const directions = new MapboxDirections({
    accessToken: mapboxgl.accessToken, 
    unit: 'metric'
  });
  
  map.addControl(directions, 'top-left');

  
}

