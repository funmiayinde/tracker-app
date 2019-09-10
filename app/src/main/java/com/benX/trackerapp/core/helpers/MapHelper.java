package com.benX.trackerapp.core.helpers;

import android.content.res.Resources;
import android.location.Location;

import com.benX.trackerapp.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.GeoApiContext;

import java.text.DecimalFormat;

/**
 * Created by funmiayinde on 2019-09-09.
 */
public class MapHelper {

    private static final float TITL_LEVEL = 18f;
    private static final float ZOOM_LEVEL = 18f;

    private final Resources resources;

    public MapHelper(Resources resources) {
        this.resources = resources;
    }


    private String distanceApi() {
        return resources.getString(R.string.google_maps_key);
    }

    public GeoApiContext geoContextDistanceApi() {
        return new GeoApiContext.Builder()
                .apiKey(distanceApi())
                .build();
    }

    public void defaultMapSettings(GoogleMap googleMap) {
        googleMap.getUiSettings().setZoomControlsEnabled(false);
        googleMap.getUiSettings().setMapToolbarEnabled(false);
        googleMap.getUiSettings().setRotateGesturesEnabled(true);
        googleMap.getUiSettings().setTiltGesturesEnabled(false);
        googleMap.getUiSettings().setCompassEnabled(true);
        googleMap.setBuildingsEnabled(true);
    }

    public CameraUpdate buildCameraUpdate(Location location) {
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        return buildCameraUpdate(latLng);
    }

    public CameraUpdate buildCameraUpdate(LatLng latLng) {
        CameraPosition position = new CameraPosition.Builder()
                .target(latLng)
                .tilt(TITL_LEVEL)
                .zoom(ZOOM_LEVEL)
                .build();
        return CameraUpdateFactory.newCameraPosition(position);
    }

    public void animateCamera(LatLng latLng, GoogleMap googleMap) {
        if (latLng == null)
            return;
        CameraUpdate cameraUpdate = buildCameraUpdate(latLng);
        googleMap.animateCamera(cameraUpdate);
    }

    public MarkerOptions getCurrentMarkerOptions(LatLng latLng) {
        MarkerOptions markerOptions = getMarkerOptions(latLng);
        markerOptions.flat(true);
        return markerOptions;
    }

    public MarkerOptions getMarkerOptions(LatLng latLng) {
        return new MarkerOptions()
                .icon(BitmapDescriptorFactory.defaultMarker())
                .position(latLng);
    }

    public String getDistanceInKiloMeters(double totalDistanceCovered) {
        if (totalDistanceCovered == 0.0 || totalDistanceCovered < -1) {
            return "0 Km";
        } else if (totalDistanceCovered > 0 && totalDistanceCovered < 1000) {
            return totalDistanceCovered + " meters";
        }
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return decimalFormat.format(totalDistanceCovered / 1000) + " Km";
    }

}
