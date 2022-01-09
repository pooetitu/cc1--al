package com.al.cc2.use_cases.location.application;

public class LocationDTO {
    public final String id;
    public final float latitude;
    public final float longitude;

    public LocationDTO(String id, float latitude, float longitude) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
