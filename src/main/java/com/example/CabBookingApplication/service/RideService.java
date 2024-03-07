package com.example.CabBookingApplication.service;

import com.example.CabBookingApplication.dto.RideRequest;

public interface RideService {
    Object getRides(RideRequest rideRequest);

    void chooseRide(String userName, String driverName);
}
