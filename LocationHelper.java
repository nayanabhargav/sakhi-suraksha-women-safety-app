package com.Sakhii.Suraksha;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;

public class LocationHelper {
    @SuppressLint("MissingPermission")
    public static String getLastLocationString(Context ctx) {
        try {
            LocationManager lm = (LocationManager) ctx.getSystemService(Context.LOCATION_SERVICE);
            Location loc = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (loc == null) loc = lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            if (loc != null) {
                return "https://maps.google.com/?q=" + loc.getLatitude() + "," + loc.getLongitude();
            }
        } catch (Exception ignored) {}
        return "Location not available";
    }
}
