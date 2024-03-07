package com.example.CabBookingApplication.model;

import com.example.CabBookingApplication.dto.DriverDetails;
import com.example.CabBookingApplication.dto.DriverRequestDto;
import com.example.CabBookingApplication.dto.Location;
import com.example.CabBookingApplication.dto.VehicleDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Driver {
    private DriverDetails driverDetails;
    private VehicleDetails vehicleDetails;
    private Location location;
    private Boolean isAvailable;
    private String rideWithUser;

    public Driver(DriverDetails driverDetails, VehicleDetails vehicleDetails, Location location) {
        this.driverDetails = driverDetails;
        this.vehicleDetails = vehicleDetails;
        this.location = location;
        this.isAvailable = true;
    }

    public static Driver ConvertRequestDtoToModel(DriverRequestDto driverRequestDto) {
        return new Driver(driverRequestDto.getDriverDetails(),driverRequestDto.getVehicleDetails(),driverRequestDto.getLocation());
    }
}
