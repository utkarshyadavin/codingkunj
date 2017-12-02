package com.example.android.mydost;

import android.location.Location;
import android.os.AsyncTask;
import android.util.Log;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GetClosestPoliceData extends AsyncTask<Object, String, String> {

    private String googlePlacesData;
    private GoogleMap mMap;
    String url;
    public List<Location> policeLocationList;
    private Location location;
    private Location currentLocation;
    List<Float> distance;
    List<Location> locations;
    int index;
    LatLng policeLatLng;
    Marker policeLocationMarker;
    List<String> place;
    Double userLocationLatitude;
    Double userLocationLongitude;
    Double policeLocationLatitude;
    Double policeLocationLongitude;

    {
        currentLocation = PoliceHelpline.lastlocation;
    }

    @Override
    protected String doInBackground(Object... objects) {
        mMap = (GoogleMap)objects[0];
        url = (String)objects[1];

        DownloadURL downloadURL = new DownloadURL();
        try {
            googlePlacesData = downloadURL.readUrl(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return googlePlacesData;
    }

    @Override
    protected void onPostExecute(String s){

        List<HashMap<String, String>> nearbyPlaceList;
        DataParser parser = new DataParser();
        nearbyPlaceList = parser.parse(s);
        showClosestPolice(nearbyPlaceList);
    }

    private void showClosestPolice(List<HashMap<String, String>> nearbyPlaceList)
    {
        String placeName = null;
        String vicinity = null;
        locations = new ArrayList<Location>();
        distance = new ArrayList<Float>();
        place = new ArrayList<String>();
        for(int i = 0; i < nearbyPlaceList.size(); i++)
        {
            HashMap<String, String> googlePlace = nearbyPlaceList.get(i);

            placeName = googlePlace.get("place_name");
            vicinity = googlePlace.get("vicinity");
            double lat = Double.parseDouble( googlePlace.get("lat"));
            double lng = Double.parseDouble( googlePlace.get("lng"));
            location = new Location("");
            location.setLatitude(lat);
            location.setLongitude(lng);
            distance.add(location.distanceTo(currentLocation));
            locations.add(location);
            place.add(placeName);


            /*
            markerOptions.position(latLng);
            markerOptions.title(placeName + " : "+ vicinity);
            markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
            mMap.addMarker(markerOptions);
            mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
            mMap.animateCamera(CameraUpdateFactory.zoomTo(10));
            */

        }
        index = 0;
        float minDistance = distance.get(index);
        for (int i = 0; i < distance.size(); i++) {
            if (minDistance > distance.get(i)) {
                index = i;
                minDistance = distance.get(index);
            }
        }

        Log.d("index", String.valueOf(index));
        Log.d("distance", String.valueOf(distance));
        Log.d("palce", String.valueOf(place));
        Log.d("minDistance", String.valueOf(minDistance));
        Log.d("location", String.valueOf(locations));
        policeLatLng = new LatLng(locations.get(index).getLatitude(), locations.get(index).getLongitude());
        Log.d("pll", String.valueOf(policeLatLng));
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(policeLatLng);
        markerOptions.title(place.get(index) + " : "+ vicinity);

        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
        policeLocationMarker = mMap.addMarker(markerOptions);
        userLocationLatitude = currentLocation.getLatitude();
        userLocationLongitude = currentLocation.getLongitude();
        policeLocationLatitude = locations.get(index).getLatitude();
        policeLocationLongitude = locations.get(index).getLongitude();
    }
}
