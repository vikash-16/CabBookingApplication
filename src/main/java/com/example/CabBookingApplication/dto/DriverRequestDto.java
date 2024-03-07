package com.example.CabBookingApplication.dto;

import lombok.Data;

@Data
public class DriverRequestDto {
    private DriverDetails driverDetails;
    private VehicleDetails vehicleDetails;
    private Location location;
}
