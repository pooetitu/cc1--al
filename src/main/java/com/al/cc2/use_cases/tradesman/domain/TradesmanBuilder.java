package com.al.cc2.use_cases.tradesman.domain;

import com.al.cc2.use_cases.location.domain.Location;
import com.al.cc2.use_cases.location.domain.LocationID;
import com.al.cc2.use_cases.membership.domain.MembershipBuilder;
import com.al.cc2.use_cases.subscription.domain.Subscription;

public class TradesmanBuilder extends MembershipBuilder {
    private final LocationBuilder locationBuilder;

    public TradesmanBuilder() {
        super();
        locationBuilder = new LocationBuilder();
    }

    public LocationBuilder withLocation() {
        return locationBuilder;
    }

    public Tradesman build() {
        return new Tradesman(membershipID, email, password, paymentInformations, birthdate, firstName, lastName, new Subscription(subscriptionBuilder.getSubscriptionType()), new Location(locationBuilder.locationID, locationBuilder.latitude, locationBuilder.longitude));
    }

    public class LocationBuilder {
        private LocationID locationID;
        private float longitude;
        private float latitude;

        public LocationBuilder withLocationID(LocationID locationID) {
            this.locationID = locationID;
            return this;
        }

        public LocationBuilder withLongitude(float longitude) {
            this.longitude = longitude;
            return this;
        }

        public LocationBuilder withLatitude(float latitude) {
            this.latitude = latitude;
            return this;
        }

        public TradesmanBuilder end() {
            return TradesmanBuilder.this;
        }
    }
}
