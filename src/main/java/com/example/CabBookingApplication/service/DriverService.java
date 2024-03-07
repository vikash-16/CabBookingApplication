package com.example.CabBookingApplication.service;

import com.example.CabBookingApplication.dto.DriverRequestDto;
import com.example.CabBookingApplication.model.Driver;

import java.util.List;

public interface DriverService {

    String addDriver(DriverRequestDto driverRequestDto);

    List<Driver> getDrivers();

}
