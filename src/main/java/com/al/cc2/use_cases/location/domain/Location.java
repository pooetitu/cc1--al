package com.al.cc2.use_cases.location.domain;

import com.al.cc2.kernel.Entity;

public class Location implements Entity<LocationID> {
    private final LocationID locationID;
    private final float latitude;
    private final float longitude;

    public Location(LocationID locationID, float latitude, float longitude) {
        this.locationID = locationID;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public LocationID id() {
        return locationID;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }
}
