package com.al.cc2.use_cases.location.domain;

import com.al.cc2.kernel.Repository;

import java.util.UUID;

public interface LocationRepository extends Repository<LocationID, Location> {
    default LocationID nextId() {
        return LocationID.fromUUID(UUID.randomUUID());
    }
}
