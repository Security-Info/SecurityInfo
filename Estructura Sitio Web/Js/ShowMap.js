var map;
function initMap () 
{
    let map = new google.maps.Map(document.getElementById('blockMap'),
        {center: {lat: 4.635022565895929, lng: -74.09219028059591}, 
        zoom: 20,
    });
    let marker = new google.maps.Marker({
        position: {lat: 43.542194, lng: -5.676875}, 
        map: map, 
        title: 'Acuario de Gijón'
    });
}