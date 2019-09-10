package com.benX.trackerapp.core.interpolators;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by funmiayinde on 2019-09-09.
 */
public interface LatLngInterpolator {

    LatLng interpolate(float fraction, LatLng origin, LatLng destination);
}
